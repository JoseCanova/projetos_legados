package org.nanotek.configuration.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.JsonMessage;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.ReleaseBean;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.Language;
import org.nanotek.beans.entity.Release;
import org.nanotek.beans.entity.ReleaseGroup;
import org.nanotek.beans.entity.ReleasePackaging;
import org.nanotek.beans.entity.ReleaseStatus;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.repository.jpa.LanguageRepository;
import org.nanotek.repository.jpa.ReleaseGroupJpaRepository;
import org.nanotek.repository.jpa.ReleasePackagingRepository;
import org.nanotek.repository.jpa.ReleaseStatusRepository;
import org.nanotek.service.CsvMessageHandler;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.nanotek.service.jpa.ReleaseJpaService;
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
@IntegrationComponentScan(basePackageClasses = {ReleaseIntegrationConfiguration.class})
public class ReleaseIntegrationConfiguration {

	private final Logger logger = LoggerFactory.getLogger(ReleaseIntegrationConfiguration.class);

	@Value("${server.port}")
	private String serverPort;
	
	@Bean
	@Qualifier(value="releaseChannel")
	MessageChannel releaseChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="releaseReplyChannel")
	MessageChannel releaseReplyChannel() {
		return new DirectChannel();
	}

	
	@Bean(name = "releaseTaskExecutor")
	@Qualifier(value = "releaseTaskExecutor")
	public ThreadPoolTaskExecutor releaseTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(200);
		executor.setQueueCapacity(2500000);
		executor.setThreadNamePrefix("releaseTaskExecutor");
		executor.initialize();
		return executor;
	}
	
	
	@Bean
	@Qualifier(value="releaseIntegrationStartChannel")
	MessageChannel releaseIntegrationStartChannel(
			@Autowired @Qualifier("releaseTaskExecutor") ThreadPoolTaskExecutor executor) {
		return new ExecutorChannel(executor);
	}
	
	@Bean
	RequestMapping initRelease() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET, HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/initRelease");
		return mapping;
	}
	
	@Bean
	@Qualifier("releaseGate")
	HttpRequestHandlingMessagingGateway releaseGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(initRelease());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(releaseChannel());
		gateway.setReplyChannel(releaseReplyChannel());
		return gateway;
	}
	
	@Bean
	@ConfigurationProperties(prefix = "releasebean")
	@Qualifier(value="releaseMapStrategy")
	BaseMapColumnStrategy<ReleaseBean> releaseMapStrategy(){ 
		return new BaseMapColumnStrategy<>();
	}

	@Bean
	@Qualifier(value="releaseCsvToBean")
	CsvToBean<ReleaseBean> releaseCsvToBean() {
		return new CsvToBean<>();
	}
	
	@Bean
	@Qualifier(value="releaseParser")
	BaseMapParser<ReleaseBean> releaseParser() { 
		return new BaseMapParser<>(releaseMapStrategy());
	}
	
	
	@Service
	class ReleaseProcessor extends CsvBaseProcessor<ReleaseBean, BaseMapParser<ReleaseBean>>{

		public ReleaseProcessor
		(@Autowired @Qualifier("releaseParser") BaseMapParser<ReleaseBean> parser,
				@Autowired @Qualifier("releaseCsvToBean") CsvToBean<ReleaseBean> csvToBean) {
			super(parser, csvToBean);
		} 
	}
	
	@Bean
	@Qualifier(value="releaseMessageHander")
	CsvMessageHandler releaseMessageHander
	(@Autowired @Qualifier("releaseIntegrationStartChannel") MessageChannel integrationChannel, 
			@Autowired @Qualifier("releaseReplyChannel") MessageChannel replyChannel,
			@Autowired ReleaseProcessor processor) { 
		return new CsvMessageHandler(integrationChannel , replyChannel , processor);
	}
	
	@Bean
	IntegrationFlow releaseFlowRequestHttp
	(@Autowired @Qualifier("releaseMessageHander") CsvMessageHandler handler,
			@Autowired @Qualifier("releaseChannel") MessageChannel channel) { 
		return IntegrationFlows
				.from(channel)
				.handle(handler)
				.get();
	}
	
	@MessageEndpoint
	class ReleaseTransformer implements GenericTransformer<ReleaseBean , Release>{

		@Autowired
		ArtistCreditJpaService creditService;
		
		@Autowired
		ReleaseStatusRepository statusRep; 
		
		@Autowired
		ReleaseGroupJpaRepository groupRep;
		
		@Autowired
		ReleasePackagingRepository packRep;
		
		@Autowired
		LanguageRepository langRep; 
		
		
		@Override
		public Release transform(ReleaseBean source) {
			
			Optional<ReleaseStatus> optStatus = Base.NULL_VALUE(ReleaseStatus.class);
			ReleaseStatus status = null;
			
			Optional<ReleasePackaging> optPack = Base.NULL_VALUE(ReleasePackaging.class);
			ReleasePackaging pack = null; 
			
			Optional<ReleaseGroup> optGroup = Base.NULL_VALUE(ReleaseGroup.class);
			ReleaseGroup group = null;
			
			Optional<Language> optLanguage = Base.NULL_VALUE(Language.class);
			Language language = null;
			
			Optional<ArtistCredit> optCredit = Base.NULL_VALUE(ArtistCredit.class);
			ArtistCredit credit = null;
			
			if (source.getStatus() !=null) {
			 optStatus = statusRep.findById(source.getStatus());
				 if (optStatus.isPresent())
					 status =  optStatus.get();
			}
			
			if (source.getPackaging() !=null) { 
				optPack = packRep.findById(source.getPackaging());
				if (optPack.isPresent())
					pack = optPack.get();
			}
			
			if(source.getReleaseGroup() !=null) { 
				optGroup = groupRep.findById(source.getReleaseGroup());
				if(optGroup.isPresent())
					group = optGroup.get();
			}
			
			if (source.getLanguage() !=null) { 
				optLanguage  = langRep.findById(source.getLanguage());
				if (optLanguage.isPresent()) { 
					language = optLanguage.get();
				}
			}
			
			if (source.getArtistCreditId() !=null){ 
				optCredit = creditService.findById(source.getArtistCreditId());
				if(optCredit.isPresent())
					credit = optCredit.get();
			}
			
			return new Release(source.getId(),source.getGid(), 
					source.getName(),source.getBarcode(),source.getComment(),
					status , pack, language , group , credit);
		} 
	}
	
	@MessageEndpoint
	class ReleaseHandler implements MessageHandler{ 

		@Autowired
		ReleaseJpaService service;

		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			service.save((Release) message.getPayload());
		}
	}
	
	@Bean IntegrationFlow processReleaseRequest
	(@Autowired ReleaseHandler handler , 
			@Autowired @Qualifier("releaseIntegrationStartChannel") MessageChannel executorChannel,
			@Autowired ReleaseTransformer transformer) { 
		return IntegrationFlows
				.from(executorChannel)
				.transform(transformer)
				.handle(handler)
				.get();
	}
	
}
