package org.nanotek.configuration.csv;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.JsonMessage;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.entity.Area;
import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistBeginDate;
import org.nanotek.beans.entity.ArtistComment;
import org.nanotek.beans.entity.ArtistEndDate;
import org.nanotek.beans.entity.ArtistType;
import org.nanotek.beans.entity.Gender;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.repository.jpa.AreaRepository;
import org.nanotek.repository.jpa.ArtistBeginDateRepository;
import org.nanotek.repository.jpa.ArtistEndDateRespository;
import org.nanotek.repository.jpa.ArtistRepository;
import org.nanotek.repository.jpa.ArtistTypeRepository;
import org.nanotek.repository.jpa.GenderRepository;
import org.nanotek.service.CsvMessageHandler;
import org.nanotek.service.jpa.ArtistCommentJpaService;
import org.nanotek.service.jpa.ArtistJpaService;
import org.nanotek.service.parser.BaseMapParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.bean.CsvToBean;

@Configuration
@EnableIntegration
@EnableConfigurationProperties
@IntegrationComponentScan(basePackageClasses = {ArtistIntegrationConfiguration.class})
public class ArtistIntegrationConfiguration {

	private final Logger logger = LoggerFactory.getLogger(ArtistIntegrationConfiguration.class);

	@Value("${server.port}")
	private String serverPort;

	@Bean
	@Qualifier(value="artistChannel")
	MessageChannel artistChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="artistReplyChannel")
	MessageChannel artistReplyChannel() {
		return new DirectChannel();
	}

	@Bean(name = "artistTaskExecutor")
	@Qualifier(value = "artistTaskExecutor")
	public ThreadPoolTaskExecutor artistTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(200);
		executor.setQueueCapacity(2500000);
		executor.setThreadNamePrefix("artistTaskExecutor");
		executor.initialize();
		return executor;
	}

	@Bean
	@Qualifier(value="artistIntegrationStartChannel")
	MessageChannel artistIntegrationStartChannel(
			@Autowired @Qualifier("artistTaskExecutor") ThreadPoolTaskExecutor executor) {
		return new ExecutorChannel(executor);
	}

	@Bean
	RequestMapping initArtist() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET, HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/initArtist");
		return mapping;
	}

	@Bean
	@Qualifier("artistGate")
	HttpRequestHandlingMessagingGateway artistGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(initArtist());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(artistChannel());
		gateway.setReplyChannel(artistReplyChannel());
		return gateway;
	}

	@Bean
	@ConfigurationProperties(prefix = "artist")
	@Qualifier(value="artistMapStrategy")
	BaseMapColumnStrategy<ArtistBean> artistMapStrategy(){ 
		return new BaseMapColumnStrategy<>();
	}

	@Bean
	@Qualifier(value="artistCsvToBean")
	CsvToBean<ArtistBean> artistCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value="artistParser")
	BaseMapParser<ArtistBean> artistParser() { 
		return new BaseMapParser<>(artistMapStrategy());
	}


	@Service
	class ArtistProcessor extends CsvBaseProcessor<ArtistBean, BaseMapParser<ArtistBean>>{

		public ArtistProcessor
		(@Autowired @Qualifier("artistParser") BaseMapParser<ArtistBean> parser,
				@Autowired @Qualifier("artistCsvToBean") CsvToBean<ArtistBean> csvToBean) {
			super(parser, csvToBean);
		} 
	}

	@Bean
	@Qualifier(value="artistMessageHander")
	CsvMessageHandler artistMessageHander
	(@Autowired @Qualifier("artistIntegrationStartChannel") MessageChannel integrationChannel, 
			@Autowired @Qualifier("artistReplyChannel") MessageChannel replyChannel,
			@Autowired ArtistProcessor processor) { 
		return new CsvMessageHandler(integrationChannel , replyChannel , processor);
	}

	@Bean
	IntegrationFlow artistFlowRequestHttp
	(@Autowired @Qualifier("artistMessageHander") CsvMessageHandler handler,
			@Autowired @Qualifier("artistChannel") MessageChannel channel) { 
		return IntegrationFlows
				.from(channel)
				.handle(handler)
				.get();
	}

	@MessageEndpoint
	class ArtistTransformer implements GenericTransformer<ArtistBean , ArtistMessageHolder>{

		@Autowired
		ArtistRepository arep;
		
		@Autowired
		GenderRepository genderRepository;

		@Autowired
		AreaRepository areaRepository;

		@Autowired
		ArtistTypeRepository typeRepository;

		@Override
		public ArtistMessageHolder transform(ArtistBean source) {
			
			arep.findByArtistId(source.getId()).ifPresent(a -> {throw new MessagingException("Artist Present" + a.toJson());});
			
			Artist artist = new Artist(source.getId(),source.getName(),source.getGid(),source.getSortName());

			if (source.getBeginDateYear() != null) {
				ArtistBeginDate beginDate = new ArtistBeginDate(source.getBeginDateYear() , source.getBeginDateMonth() , source.getBeginDateDay());
				artist.setArtistBeginDate(beginDate);
			}

			if (source.getEndDateYear()!= null) {
				ArtistEndDate endDate = new ArtistEndDate(source.getEndDateYear() , source.getEndDateMonth() , source.getEndDateDay());
				artist.setArtistEndDate(endDate);
			}

			if (source.getGender() != null) { 
				Optional<Gender> optGender = genderRepository.findById(source.getGender());
				if (optGender.isPresent())
					artist.setGender(optGender.get());
			}

			if (source.getBeginArea()!=null) { 
				Optional<Area> optBegin = areaRepository.findByAreaId(source.getBeginArea());
				if (optBegin.isPresent())
					artist.setBeginArea(optBegin.get());
			}

			if (source.getEndArea()!=null) { 
				Optional<Area> optEnd = areaRepository.findByAreaId(source.getEndArea());
				if (optEnd.isPresent())
					artist.setEndArea(optEnd.get());
			}

			if (source.getType() !=null) {
				Optional<ArtistType> optType =  typeRepository.findById(source.getType());
				if (optType.isPresent()) {
					artist.setType(optType.get());
				}
			}
			
			if (source.getArea()!=null) { 
				Optional<Area> optArea = areaRepository.findByAreaId(source.getArea());
				if (optArea.isPresent())
					artist.setArea(optArea.get());
			}
			
			ArtistComment artistComment = null;
			if(NotEmpty(source.getComment())) { 
				 artistComment = new ArtistComment(source.getComment());
			}
			
			return new ArtistMessageHolder(artist, artistComment);
		}

		private boolean NotEmpty(String comment) {
			return comment !=null && !"".contentEquals(comment.trim());
		} 
	}

	@MessageEndpoint
	class ArtistHandler implements MessageHandler{ 

		@Autowired
		ArtistJpaService service;
		
		@Autowired
		ArtistCommentJpaService commentService;
		
		@Autowired
		ArtistBeginDateRepository beginDateRepository; 
		
		@Autowired
		ArtistEndDateRespository endDateRepository;
		
		@Autowired
		AreaRepository areaRepository;
		
		@Autowired 
		ArtistTypeRepository typeRepository;
		
		@Autowired
		GenderRepository genderRepository;
		
		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			ArtistMessageHolder messageHolder = (ArtistMessageHolder) message.getPayload();
			Artist transientArtist = messageHolder.getArtist();
			ArtistComment comment = messageHolder.getArtistComment();
			
			if(transientArtist.getArtistBeginDate() !=null)
				transientArtist.setArtistBeginDate(beginDateRepository.save(transientArtist.getArtistBeginDate()));
			
			if (transientArtist.getArtistEndDate() !=null)
				transientArtist.setArtistEndDate(endDateRepository.save(transientArtist.getArtistEndDate()));
			
			if (transientArtist.getType() == null) { 
				ArtistType type = typeRepository.findByNameContainingIgnoreCase("Not").iterator().next();
				transientArtist.setType(type);
			}
			
			service.save(transientArtist);
			if (comment !=null) { 
				comment.setArtist(transientArtist);
				commentService.save(comment);
			}
		}
	}

	@Bean IntegrationFlow processArtistRequest
	(@Autowired ArtistHandler handler , 
			@Autowired @Qualifier("artistIntegrationStartChannel") MessageChannel executorChannel,
			@Autowired ArtistTransformer transformer) { 
		return IntegrationFlows
				.from(executorChannel)
				.transform(transformer)
				.handle(handler)
				.get();
	}
	
	class ArtistMessageHolder implements Serializable{ 
		
		private static final long serialVersionUID = -853649880260963575L;

		private Artist artist;
		
		private ArtistComment artistComment;

		public ArtistMessageHolder(Artist artist, ArtistComment artistComment) {
			super();
			this.artist = artist;
			this.artistComment = artistComment;
		}

		public Artist getArtist() {
			return artist;
		}

		public ArtistComment getArtistComment() {
			return artistComment;
		}
	}

}