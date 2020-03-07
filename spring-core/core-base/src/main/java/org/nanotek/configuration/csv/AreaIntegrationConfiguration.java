package org.nanotek.configuration.csv;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.JsonMessage;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.AreaBean;
import org.nanotek.beans.entity.Area;
import org.nanotek.beans.entity.AreaBeginDate;
import org.nanotek.beans.entity.AreaComment;
import org.nanotek.beans.entity.AreaEndDate;
import org.nanotek.beans.entity.AreaType;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.repository.jpa.AreaBeginDateRepository;
import org.nanotek.repository.jpa.AreaCommentRepository;
import org.nanotek.repository.jpa.AreaEndDateRepository;
import org.nanotek.service.jpa.AreaJpaService;
import org.nanotek.service.jpa.AreaTypeJpaService;
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
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.bean.CsvToBean;

@Configuration
@EnableIntegration
@EnableConfigurationProperties
@IntegrationComponentScan(basePackageClasses = {AreaIntegrationConfiguration.class})
public class AreaIntegrationConfiguration {

	private final Logger logger = LoggerFactory.getLogger(AreaIntegrationConfiguration.class);

	@Value("${server.port}")
	private String serverPort;

	public AreaIntegrationConfiguration() {
	}

	@Bean
	@Qualifier(value="areaChannel")
	MessageChannel areaChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="areaReplyChannel")
	MessageChannel areaReplyChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="areaIntegrationStartChannel")
	ExecutorChannel areaIntegrationStartChannel(@Autowired @Qualifier("serviceTaskExecutor") ThreadPoolTaskExecutor executor) {
		return new ExecutorChannel(executor);
	}


	@Bean
	@Qualifier(value="areaRequestMapping")
	RequestMapping areaRequestMapping() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET, HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/area");
		return mapping;
	}

	@Bean
	@Qualifier("areaGate")
	public HttpRequestHandlingMessagingGateway areaGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(areaRequestMapping());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(areaChannel());
		gateway.setReplyChannel(areaReplyChannel());
		return gateway;
	}


	@Bean
	@ConfigurationProperties(prefix = "area")
	@Qualifier(value="areaMapStrategy")
	BaseMapColumnStrategy<AreaBean> areaMapStrategy(){ 
		return new BaseMapColumnStrategy<>();
	}

	@Bean
	@Qualifier(value="areaCsvToBean")
	CsvToBean<AreaBean> areaCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value="areaParser")
	BaseMapParser<AreaBean> areaParser() { 
		return new BaseMapParser<>(areaMapStrategy());
	}

	@Bean
	IntegrationFlow areaFlowRequestHttp
	(@Autowired AreaBeanProcessor handler,
			@Autowired @Qualifier("areaChannel") MessageChannel channel) { 
		return IntegrationFlows
				.from(channel)
				.handle(handler)
				.get();
	}


	@Bean IntegrationFlow processAreaRequest
			(@Autowired AreaHandler handler , 
			@Autowired @Qualifier("areaIntegrationStartChannel") ExecutorChannel executorChannel,
			@Autowired AreaTransformer transformer) { 
		return IntegrationFlows
				.from(executorChannel)
				.transform(transformer)
				.handle(handler)
				.get();
	}
	
	@Service
	class AreaProcessor extends CsvBaseProcessor<AreaBean, BaseMapParser<AreaBean>>{

		public AreaProcessor
		(@Autowired @Qualifier("areaParser") BaseMapParser<AreaBean> parser,
				@Autowired @Qualifier("areaCsvToBean") CsvToBean<AreaBean> csvToBean) {
			super(parser, csvToBean);
		} 
	}

	@MessageEndpoint
	class AreaBeanProcessor implements MessageHandler{ 

		@Autowired
		@Qualifier("areaIntegrationStartChannel")
		private ExecutorChannel dispatcherChannel;

		@Autowired
		@Qualifier("areaReplyChannel")
		private MessageChannel responseChannel;

		@Autowired
		private AreaProcessor processor;

		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			try { 
				processor.reopenFile();
				AreaBean area = null; 
				responseChannel.send(message);
				do{ 
					area = processor.next();
					if (area !=null) { 
						Message<?> m = MessageBuilder.withPayload(area).build();
						dispatcherChannel.send(m);
					}
				}while(area !=null);
			}catch(Exception ex) { 
				throw new MessagingException(message , ex);
			}
		}
	}


	@MessageEndpoint
	class AreaHandler implements MessageHandler{ 
		
		@Autowired
		AreaJpaService service;
		
		@Autowired
		AreaBeginDateRepository dRep;
		
		@Autowired
		AreaEndDateRepository eRep;
		
		@Autowired
		AreaCommentRepository cRep;
		
		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			AreaHolder holder = (AreaHolder) message.getPayload();
			Area transientArea = holder.getArea();
			if (transientArea.getAreaBeginDate() !=null) {
				AreaBeginDate bd = dRep.save(transientArea.getAreaBeginDate());
				transientArea.setAreaBeginDate(bd);
			}
			if(transientArea.getAreaEndDate() !=null) {
				AreaEndDate ed = eRep.save(transientArea.getAreaEndDate());
				transientArea.setAreaEndDate(ed);
			}
			AreaComment areaComment = holder.getAreaComment();
			Area persitedArea = service.save(transientArea);
			if (areaComment !=null) {
				areaComment.setArea(persitedArea);
				cRep.save(areaComment);
			}
		}
	}

	@MessageEndpoint
	class AreaTransformer implements GenericTransformer<AreaBean  , AreaHolder>{

		@Autowired
		AreaTypeJpaService service;
		
		@Override
		public AreaHolder transform(AreaBean source) {
			Area area = new Area(source.getId(),source.getName(),source.getGid());
			if(source.getType() == null)
				throw new MessagingException("No type found for bean");
			Optional<AreaType> optType = service.findById(source.getType());
			area.setType(optType.get());
			if (source.getBeginDateYear() !=null) { 
				AreaBeginDate eDate  = new AreaBeginDate(source.getBeginDateYear(), source.getBeginDateMonth(), source.getBeginDateDay());
				area.setAreaBeginDate(eDate);
			}
			if (source.getEndDateYead() !=null) { 
				AreaEndDate eDate = new AreaEndDate(source.getEndDateYead(),source.getEndDateMonth(),source.getEndDateDay());
				area.setAreaEndDate(eDate);
			}
			AreaComment areaComment = null;
			if (NotEmpty(source.getComment())) { 
				areaComment = new AreaComment(source.getComment());
			}
			return new AreaHolder(area,areaComment);
		}

		private boolean NotEmpty(String comment) {
			return comment !=null && !"".contentEquals(comment.trim());
		} 
	}
	
	class AreaHolder implements Serializable{ 
		
		private static final long serialVersionUID = -544891655711717670L;

		private Area area; 
		
		private AreaComment areaComment;

		public AreaHolder(Area area, AreaComment areaComment) {
			super();
			this.area = area;
			this.areaComment = areaComment;
		}

		public Area getArea() {
			return area;
		}

		public AreaComment getAreaComment() {
			return areaComment;
		}
		
	}

}
