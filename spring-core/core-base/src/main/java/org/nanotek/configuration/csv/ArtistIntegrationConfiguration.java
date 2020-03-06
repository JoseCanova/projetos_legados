package org.nanotek.configuration.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.JsonMessage;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.Language;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.repository.jpa.LanguageRepository;
import org.nanotek.service.CsvMessageHandler;
import org.nanotek.service.jpa.ArtistCreditJpaService;
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
	class ArtistTransformer implements GenericTransformer<ArtistBean , Artist>{

		@Autowired
		ArtistCreditJpaService creditService;
		
		@Autowired
		LanguageRepository langRep; 
		
		@Override
		public Artist transform(ArtistBean source) {
			
			Optional<Language> optLanguage = Base.NULL_VALUE(Language.class);
			Language language = null;
			
			Optional<ArtistCredit> optCredit = Base.NULL_VALUE(ArtistCredit.class);
			ArtistCredit credit = null;
			
			return new Artist();
		} 
	}
	
	@MessageEndpoint
	class ArtistHandler implements MessageHandler{ 

		@Autowired
		ArtistJpaService service;

		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			service.save((Artist) message.getPayload());
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
	
}