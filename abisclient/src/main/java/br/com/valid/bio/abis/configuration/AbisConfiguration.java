package br.com.valid.bio.abis.configuration;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;

import br.com.valid.bio.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.abis.configuration.mongo.MongoProperties;

@Configuration
public class AbisConfiguration {
	
	private static final Logger logger = LoggerFactory.getLogger(AbisConfiguration.class);

	@Autowired
	private MongoProperties mongoProperties;

	@Autowired
	private ChannelConfiguration channelConfiguration;

	@Autowired
	@Qualifier("normalPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor normalPriorityThreadPoolExecutor;
	
	
	public AbisConfiguration() {
	}

	@Bean(name="mongoDbFactory")
	public MongoDbFactory mongoDbFactory() throws UnknownHostException{
		return new SimpleMongoDbFactory(new MongoClient(mongoProperties.getUri() , mongoProperties.getPort()), mongoProperties.getDatabaseName());
	}

	@Bean
	public ObjectMapper defaultObjectMapper() { 
		return new ObjectMapper();
	}

    @Bean
    public MessagingTemplate messageTemplate(){ 
    	return new MessagingTemplate();
    }
    
    @Bean
    public WireTap logWireTap() { 
    	return new WireTap ("loggingChannel");
    }
    
    @Bean
    public List<ChannelInterceptor> channelInterceptorList(){ 
    	List<ChannelInterceptor> interceptorList = new ArrayList<>();
    	interceptorList.add(logWireTap());
    	return interceptorList;
    }
	
    @Bean
    public IntegrationFlow loggingFlow(@Autowired @Qualifier("loggingChannel") MessageChannel logChannel) {
        return  IntegrationFlows
        		.from(logChannel)
        		.handle(m -> logMessage(m))
        		.get();
    }
    
    private void logMessage(Message<?> m) {
    	logger.debug(m.getPayload().toString());
	}
    
    @Bean
    @Qualifier("serviceNameRouterBean")
    public AbstractMessageRouter serviceNameRouter() {
        return new AbstractMessageRouter() {
            @Override
            protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
                MessageChannel messageChannel; 
                String service = message.getHeaders().get(SERVICE_HEADER).toString();
                switch (service) { 
                	case "ENROLL": 
                		messageChannel = channelConfiguration.kairosEnrollChannel();
                		break;
                	case "RECOGNIZE": 
                		messageChannel = channelConfiguration.kairosRecognizeChannel(); 
                		break;
                	case "VERIFY": 
                		messageChannel = channelConfiguration.kairosVerifyChannel();
                		break;
                	default: 
                		messageChannel = channelConfiguration.conveniadasDefaultRouterChannel();
                		break;
                }
            	return Stream.of(messageChannel).collect(Collectors.toList());
            }
        };
    }

}
