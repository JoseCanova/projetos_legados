package org.nanotek.configuration.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.JsonMessage;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.InstrumentBean;
import org.nanotek.beans.entity.Instrument;
import org.nanotek.beans.entity.InstrumentComment;
import org.nanotek.beans.entity.InstrumentDescription;
import org.nanotek.beans.entity.InstrumentType;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.repository.jpa.InstrumentCommentRepository;
import org.nanotek.repository.jpa.InstrumentDescriptionRepository;
import org.nanotek.service.jpa.InstrumentJpaService;
import org.nanotek.service.jpa.InstrumentTypeJpaService;
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
@IntegrationComponentScan(basePackageClasses = {InstrumentIntegrationConfiguration.class})
public class InstrumentIntegrationConfiguration {

	private final Logger logger = LoggerFactory.getLogger(InstrumentIntegrationConfiguration.class);

	@Value("${server.port}")
	private String serverPort;

	public InstrumentIntegrationConfiguration() {
	}

	@Bean
	@Qualifier(value="instrumentChannel")
	MessageChannel instrumentChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="instrumentReplyChannel")
	MessageChannel instrumentReplyChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="instrumentIntegrationStartChannel")
	ExecutorChannel instrumentIntegrationStartChannel(@Autowired @Qualifier("serviceTaskExecutor") ThreadPoolTaskExecutor executor) {
		return new ExecutorChannel(executor);
	}


	@Bean
	@Qualifier(value="instrumentRequestMapping")
	RequestMapping instrumentRequestMapping() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET, HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/instrument");
		return mapping;
	}

	@Bean
	@Qualifier("instrumentGate")
	public HttpRequestHandlingMessagingGateway instrumentGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(instrumentRequestMapping());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(instrumentChannel());
		gateway.setReplyChannel(instrumentReplyChannel());
		return gateway;
	}


	@Bean
	@ConfigurationProperties(prefix = "instrument")
	@Qualifier(value="instrumentMapStrategy")
	BaseMapColumnStrategy<InstrumentBean> intrumentBaseMap(){ 
		return new BaseMapColumnStrategy<>();
	}

	@Bean
	@Qualifier(value="instrumentCsvToBean")
	CsvToBean<InstrumentBean> instrumentCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value="instrumentParser")
	BaseMapParser<InstrumentBean> instrumentParser() { 
		return new BaseMapParser<>(intrumentBaseMap());
	}

	@Bean
	IntegrationFlow instrumentFlowRequestHttp
	(@Autowired InstrumentBeanProcessor handler,
			@Autowired @Qualifier("instrumentChannel") MessageChannel channel) { 
		return IntegrationFlows
				.from(channel)
				.handle(handler)
				.get();
	}


	@Bean IntegrationFlow processInstrumentRequest
			(@Autowired InstrumentHandler handler , 
			@Autowired @Qualifier("instrumentIntegrationStartChannel") ExecutorChannel executorChannel,
			@Autowired InstrumentTransformer transformer) { 
		return IntegrationFlows
				.from(executorChannel)
				.transform(transformer)
				.handle(handler)
				.get();
	}
	
	@Service
	class InstrumentProcessor extends CsvBaseProcessor<InstrumentBean, BaseMapParser<InstrumentBean>>{

		public InstrumentProcessor
		(@Autowired @Qualifier("instrumentParser") BaseMapParser<InstrumentBean> parser,
				@Autowired @Qualifier("instrumentCsvToBean") CsvToBean<InstrumentBean> csvToBean) {
			super(parser, csvToBean);
		} 
	}

	@MessageEndpoint
	class InstrumentBeanProcessor implements MessageHandler{ 

		@Autowired
		@Qualifier("instrumentIntegrationStartChannel")
		private ExecutorChannel dispatcherChannel;

		@Autowired
		@Qualifier("instrumentReplyChannel")
		private MessageChannel responseChannel;

		@Autowired
		private InstrumentProcessor processor;

		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			try { 
				processor.reopenFile();
				InstrumentBean instrument = null; 
				responseChannel.send(message);
				do{ 
					instrument = processor.next();
					if (instrument !=null) { 
						Message<?> m = MessageBuilder.withPayload(instrument).build();
						dispatcherChannel.send(m);
					}
				}while(instrument !=null);
			}catch(Exception ex) { 
				throw new MessagingException(message , ex);
			}
		}
	}


	@MessageEndpoint
	class InstrumentHandler implements MessageHandler{ 
		
		@Autowired
		InstrumentJpaService service;
		
		@Autowired
		InstrumentCommentRepository commentRepository;
		
		@Autowired 
		InstrumentDescriptionRepository descRepository;
		
		
		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			InstrumentHolder holder = (InstrumentHolder) message.getPayload();
			Instrument transientInstrument = holder.getOptInstrument().get();
			
			transientInstrument = service.save(transientInstrument);
			
			Optional<InstrumentComment> oic = holder.getOptComment();
			Optional<InstrumentDescription> oid = holder.getOpdDescription();
			
			if (oic.isPresent()) { 
				InstrumentComment ic = oic.get();
				ic.setInstrument(transientInstrument);
				commentRepository.save(ic);
			}
			
			if(oid.isPresent()) {
				InstrumentDescription id = oid.get();
				id.setInstrument(transientInstrument);
				descRepository.save(id);
			}
		}
	}

	@MessageEndpoint
	class InstrumentTransformer implements GenericTransformer<InstrumentBean  , InstrumentHolder>{

		@Autowired
		InstrumentTypeJpaService service;

		@Override
		public InstrumentHolder transform(InstrumentBean source) {
			Optional<InstrumentType> optType = Base.NULL_VALUE(InstrumentType.class);
			Optional<InstrumentComment> optComment = Base.NULL_VALUE(InstrumentComment.class);
			Optional<InstrumentDescription> optDescription = Base.NULL_VALUE(InstrumentDescription.class);
			
			if (source.getType() !=null)
				optType = service.findById(source.getType());
			
			if(optType.isEmpty())
				throw new MessagingException("No type found for bean");
			
			if (NotEmpty(source.getComment())) {
				InstrumentComment ic = new InstrumentComment(source.getComment());
				optComment = Optional.of(ic);
			}

			if (NotEmpty(source.getDescription())) {
				InstrumentDescription id = new InstrumentDescription(source.getDescription());
				optDescription = Optional.of(id);
			}
			
			
			InstrumentType itye  = optType.get();
			Instrument instrument = new Instrument(
											source.getId() , 
											source.getGid() , 
											source.getName() , 
											itye 
											);
			Optional<Instrument> optInst = Optional.of(instrument);
			return new InstrumentHolder(optInst , optComment , optDescription);
		}

		private boolean NotEmpty(String str) {
			return str !=null && !"".contentEquals(str.trim());
		} 
	}

	class InstrumentHolder{ 
		private Optional<Instrument> optInstrument; 
		private Optional<InstrumentComment> optComment; 
		private Optional<InstrumentDescription> opdDescription;
		public InstrumentHolder(Optional<Instrument> optInstrument, Optional<InstrumentComment> optComment,
				Optional<InstrumentDescription> opdDescription) {
			super();
			this.optInstrument = optInstrument;
			this.optComment = optComment;
			this.opdDescription = opdDescription;
		}
		public Optional<Instrument> getOptInstrument() {
			return optInstrument;
		}
		public Optional<InstrumentComment> getOptComment() {
			return optComment;
		}
		public Optional<InstrumentDescription> getOpdDescription() {
			return opdDescription;
		}
	}
	
}
