package br.com.valid.bio.conveniadas.abis.configuration;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;

import br.com.valid.bio.conveniadas.abis.configuration.mongo.MongoProperties;

@Configuration
public class AbisConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(AbisConfiguration.class);

	@Autowired
	private MongoProperties mongoProperties;

	@Autowired
	@Qualifier("normalPriorityThreadPoolExecutor")
	private ThreadPoolTaskExecutor normalPriorityThreadPoolExecutor;

	@Value("${defaultTimeoutInterval}")
	private Long defaultTimeoutInterval;

	@Autowired
	private ApplicationContext applicationContext;

	public AbisConfiguration() {
	}

	//	@Bean
	//	public OAuth2RestTemplate abisOAuthRestTemplate() {
	//		return new OAuth2RestTemplate(null, oauth2Context);
	//	}

	@Bean(name="mongoDbFactory")
	public MongoDbFactory mongoDbFactory() throws UnknownHostException{
		return new SimpleMongoDbFactory(new MongoClient(mongoProperties.getUri() , mongoProperties.getPort()), mongoProperties.getDatabaseName());
	}


	@Bean
	@Qualifier(value="jobMessageTemplate")
	public MessagingTemplate messagingTemplate() { 
		MessagingTemplate messagingTemplate = new MessagingTemplate();
		messagingTemplate.setBeanFactory(applicationContext);
		return  messagingTemplate;
	}

	@Bean(name="objectMapper")
	public ObjectMapper defaultObjectMapper() { 
		return new ObjectMapper();
	}

	@Primary
	@Bean("httpMessageConverters")
	public List<HttpMessageConverter<?>> httpMessageConverters(){ 
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		return converters;
	}

	@Bean(name="defaultHttpHeaderMapper")
	@Qualifier(value="defaultHttpHeaderMapper")
	public DefaultHttpHeaderMapper defaultHeaderMapper() { 
		DefaultHttpHeaderMapper mapper = new DefaultHttpHeaderMapper();
		mapper.setInboundHeaderNames(new String[] {"*"});
		mapper.setOutboundHeaderNames(new String[] {"*"});
		return mapper;
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
		//		interceptorList.add(logWireTap());
		return interceptorList;
	}

	@Bean
	public IntegrationFlow loggingFlow(@Autowired 
			@Qualifier("loggingChannel") MessageChannel logChannel) {
		return  IntegrationFlows
				.from(logChannel)
				.handle(m -> logMessage(m))
				.get();
	}

	//TODO: Implementar callback para roteador para que a envio de resposta.
	@Bean
	public IntegrationFlow errorHandlingFlow(
			@Autowired @Qualifier("errorHandlerOutputChannel") MessageChannel errorChannel) {
		return  IntegrationFlows
				.from(errorChannel)
				.handle(m -> logMessage(m))
				.get();
	}

	private void logMessage(Message<?> m) {
		logger.debug(m.getPayload().toString());
	}

	@Bean(name="methodToHttpMethodInterpreter")
	@Qualifier(value="methodToHttpMethodInterpreter")
	public Map<String , HttpMethod> methodToHttpMethodInterpreter(){ 
		Map<String , HttpMethod> methodInterpreter = new HashMap<String , HttpMethod>();
		methodInterpreter.put("GET", HttpMethod.GET);
		methodInterpreter.put("PUT", HttpMethod.PUT);
		methodInterpreter.put("POST", HttpMethod.POST);
		methodInterpreter.put("DELETE", HttpMethod.DELETE);
		methodInterpreter.put("PATCH", HttpMethod.PATCH);
		methodInterpreter.put("TRACE", HttpMethod.TRACE);
		methodInterpreter.put("OPTIONS", HttpMethod.OPTIONS);
		methodInterpreter.put("HEAD", HttpMethod.HEAD);
		return methodInterpreter;
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
		return threadPoolTaskScheduler;
	}

}
