package org.nanotek.configuration.csv;

import org.nanotek.JsonMessage;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.ArtistTypeBean;
import org.nanotek.beans.entity.ArtistType;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.repository.jpa.ArtistTypeRepository;
import org.nanotek.service.CsvMessageHandler;
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
@IntegrationComponentScan(basePackageClasses = {ArtistTypeInegrationConfiguration.class})
public class ArtistTypeInegrationConfiguration {

	private final Logger logger = LoggerFactory.getLogger(ArtistTypeInegrationConfiguration.class);

	@Value("${server.port}")
	private String serverPort;

	@Bean
	@Qualifier(value="artistTypeChannel")
	MessageChannel artistTypeChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="artistTypeReplyChannel")
	MessageChannel artistTypeReplyChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="artistTypeIntegrationStartChannel")
	MessageChannel artistTypeIntegrationStartChannel(
			@Autowired @Qualifier("serviceTaskExecutor") ThreadPoolTaskExecutor executor) {
		return new ExecutorChannel(executor);
	}

	@Bean
	RequestMapping initArtistType() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET, HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/initArtistType");
		return mapping;
	}

	@Bean
	@Qualifier("artistTypeGate")
	public HttpRequestHandlingMessagingGateway artistTypeGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(initArtistType());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(artistTypeChannel());
		gateway.setReplyChannel(artistTypeReplyChannel());
		return gateway;
	}

	@Bean
	@ConfigurationProperties(prefix = "artisttype")
	@Qualifier(value="artistTypeMapStrategy")
	BaseMapColumnStrategy<ArtistTypeBean> artistTypeMapStrategy(){ 
		return new BaseMapColumnStrategy<>();
	}

	@Bean
	@Qualifier(value="artistTypeCsvToBean")
	CsvToBean<ArtistTypeBean> artistTypeCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value="artistTypeParser")
	BaseMapParser<ArtistTypeBean> artistTypeParser() { 
		return new BaseMapParser<>(artistTypeMapStrategy());
	}

	@Service
	class ArtistTypeProcessor extends CsvBaseProcessor<ArtistTypeBean, BaseMapParser<ArtistTypeBean>>{

		public ArtistTypeProcessor
		(@Autowired @Qualifier("artistTypeParser") BaseMapParser<ArtistTypeBean> parser,
				@Autowired @Qualifier("artistTypeCsvToBean") CsvToBean<ArtistTypeBean> csvToBean) {
			super(parser, csvToBean);
		} 
	}

	@Bean
	@Qualifier(value="artistTypeMessageHander")
	CsvMessageHandler artistTypeMessageHander
	(@Autowired @Qualifier("artistTypeIntegrationStartChannel") MessageChannel integrationChannel, 
			@Autowired @Qualifier("artistTypeReplyChannel") MessageChannel replyChannel,
			@Autowired ArtistTypeProcessor processor) { 
		return new CsvMessageHandler(integrationChannel , replyChannel , processor);
	}

	@Bean
	IntegrationFlow artistTypeFlowRequestHttp
	(@Autowired @Qualifier("artistTypeMessageHander") CsvMessageHandler handler,
			@Autowired @Qualifier("artistTypeChannel") MessageChannel channel) { 
		return IntegrationFlows
				.from(channel)
				.handle(handler)
				.get();
	}

	@MessageEndpoint
	class ArtistTypeHandler implements MessageHandler{ 

		@Autowired
		ArtistTypeRepository repository;
		/*
		 * @Autowired InstrumentJpaService service;
		 */

		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			logger.info(message.getPayload().toString());
			repository.save((ArtistType) message.getPayload());
		}
	}

	@Bean IntegrationFlow processArtistTypeRequest
	(@Autowired ArtistTypeHandler handler , 
			@Autowired @Qualifier("artistTypeIntegrationStartChannel") MessageChannel executorChannel,
			@Autowired ArtistTypeTransformer transformer) { 
		return IntegrationFlows
				.from(executorChannel)
				.transform(transformer)
				.handle(handler)
				.get();
	}
	
	@MessageEndpoint
	class ArtistTypeTransformer implements GenericTransformer<ArtistTypeBean, ArtistType>{

		@Override
		public ArtistType transform(ArtistTypeBean source) {
			return new ArtistType(source.getId(), source.getName() , source.getParent() , source.getChildOrder() , source.getDescription() , source.getGid());
		} 
		
	}
	
}
