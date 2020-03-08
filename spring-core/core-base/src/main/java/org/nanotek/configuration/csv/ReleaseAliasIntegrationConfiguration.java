package org.nanotek.configuration.csv;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.nanotek.Base;
import org.nanotek.JsonMessage;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.beans.csv.ReleaseAliasBean;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.Release;
import org.nanotek.beans.entity.ReleaseAlias;
import org.nanotek.beans.entity.ReleaseAliasType;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.repository.jpa.ReleaseAliasTypeRepository;
import org.nanotek.service.CsvMessageHandler;
import org.nanotek.service.jpa.ReleaseAliasJpaService;
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
@IntegrationComponentScan(basePackageClasses = {ReleaseAliasIntegrationConfiguration.class})
public class ReleaseAliasIntegrationConfiguration {

	private final Logger logger = LoggerFactory.getLogger(ReleaseAliasIntegrationConfiguration.class);

	@Value("${server.port}")
	private String serverPort;


	@Bean
	@Qualifier(value="releaseAliasChannel")
	MessageChannel releaseAliasChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="releaseAliasReplyChannel")
	MessageChannel releaseAliasReplyChannel() {
		return new DirectChannel();
	}

	@Bean
	@Qualifier(value="releaseAliasIntegrationStartChannel")
	MessageChannel releaseAliasIntegrationStartChannel() {
		return new ExecutorChannel(releaseAliasTaskExecutor());
	}

	@Bean(name = "releaseAliasTaskExecutor")
	@Qualifier(value = "releaseAliasTaskExecutor")
	public ThreadPoolTaskExecutor releaseAliasTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(200);
		executor.setQueueCapacity(250000);
		executor.setThreadNamePrefix("releaseAliasTaskExecutor");
		executor.initialize();
		return executor;
	}
	
	@Bean
	RequestMapping initReleaseAlias() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET, HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/initReleaseAlias");
		return mapping;
	}

	@Bean
	@Qualifier("releaseAliasGate")
	public HttpRequestHandlingMessagingGateway releaseAliasGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(initReleaseAlias());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(releaseAliasChannel());
		gateway.setReplyChannel(releaseAliasReplyChannel());
		return gateway;
	}

	@Bean
	@ConfigurationProperties(prefix = "releasealias")
	@Qualifier(value="releaseAliasMapStrategy")
	BaseMapColumnStrategy<ReleaseAliasBean> releaseAliasMapStrategy(){ 
		return new BaseMapColumnStrategy<>();
	}

	@Bean
	@Qualifier(value="releaseAliasCsvToBean")
	CsvToBean<ReleaseAliasBean> releaseAliasCsvToBean() {
		return new CsvToBean<>();
	}

	@Bean
	@Qualifier(value="releaseAliasParser")
	BaseMapParser<ReleaseAliasBean> releaseAliasParser() { 
		return new BaseMapParser<>(releaseAliasMapStrategy());
	}

	@Service
	class ReleaseAliasProcessor extends CsvBaseProcessor<ReleaseAliasBean, BaseMapParser<ReleaseAliasBean>>{

		public ReleaseAliasProcessor
		(@Autowired @Qualifier("releaseAliasParser") BaseMapParser<ReleaseAliasBean> parser,
				@Autowired @Qualifier("releaseAliasCsvToBean") CsvToBean<ReleaseAliasBean> csvToBean) {
			super(parser, csvToBean);
		} 
	}

	@Bean
	@Qualifier(value="releaseAliasMessageHander")
	CsvMessageHandler releaseAliasMessageHander(@Autowired ReleaseAliasProcessor processor) { 
		return new CsvMessageHandler(releaseAliasIntegrationStartChannel() , releaseAliasReplyChannel() , processor);
	}

	@Bean
	IntegrationFlow releaseAliasFlowRequestHttp
	(@Autowired @Qualifier("releaseAliasMessageHander") CsvMessageHandler handler) { 
		return IntegrationFlows
				.from(releaseAliasChannel())
				.handle(handler)
				.get();
	}

	@Bean IntegrationFlow processReleaseAliasRequest
	(@Autowired ReleaseAliasHandler handler ,
	@Autowired ReleaseAliasTransformer transformer) { 
		return IntegrationFlows
				.from(releaseAliasIntegrationStartChannel())
				.transform(transformer)
				.handle(handler)
				.get();
	}

	
	@MessageEndpoint
	class ReleaseAliasHandler implements MessageHandler{ 
		
		@Autowired 
		ReleaseAliasJpaService service;
		
		@Override
		public void handleMessage(Message<?> message) throws MessagingException {
			service.save((ReleaseAlias) message.getPayload());
		}
	}
	
	@MessageEndpoint
	class ReleaseAliasTransformer implements GenericTransformer<ReleaseAliasBean , ReleaseAlias>{

		@Autowired
		ReleaseJpaService releaseService; 
		
		@Autowired
		ReleaseAliasTypeRepository repository;
		
		@Override
		public ReleaseAlias transform(ReleaseAliasBean source) {
			
			Optional<Release> optRelease = releaseService.findById(source.getRelease());
			Optional<ReleaseAliasType> ptype = Base.NULL_VALUE(ReleaseAliasType.class);
			ReleaseAliasType type = null; 
			if (!optRelease.isPresent())
				throw new MessagingException ("Release is not present " + source.getRelease());
			Release release = optRelease.get();
			if (source.getType() !=null) {
				ptype = repository.findById(source.getType());
				if (ptype.isPresent())
					type =  ptype.get();
			} 
			
			return new ReleaseAlias(source.getId() ,  source.getName() , source.getLocale() , release,
					type , source.getSortName() , source.getBeginDateYear() , source.getBeginDateMonth() , source.getBeginDateDay(),
					source.getEndDateYear() , source.getEndDateMonth() , source.getEndDateDay());
			
		} 
		
	}
	
}
