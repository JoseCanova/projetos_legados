package br.com.valid.bio.agreement;

import br.com.valid.bio.agreement.configuration.ChannelConfiguration;
import br.com.valid.bio.agreement.configuration.MongoProperties;
import br.com.valid.bio.agreement.exception.BaseException;
import br.com.valid.bio.agreement.integration.Md5Service;
import br.com.valid.bio.agreement.model.JsonMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.interceptor.WireTap;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.http.config.EnableIntegrationGraphController;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration(exclude={RabbitAutoConfiguration.class})
@EnableIntegrationGraphController
public class AgreementKairosApp {

	private static final Logger logger = LoggerFactory.getLogger(AgreementKairosApp.class);
	public static final String NOT_SAME_MD5 = "NOT SAME MD5 KEY";
	public static final String SAME_MD5 = "SAME MD5 KEY";
	
	@Autowired
	private Md5Service md5Service;
	
	@Autowired
	private MongoProperties mongoProperties;
	
	@Autowired
	private ChannelConfiguration channelConfiguration;
	
	public static void main(String[] args) {
        SpringApplication.run(AgreementKairosApp.class, args);
    }
	
    @Primary
    @Bean("httpMessageConverters")
    public List<HttpMessageConverter<?>> httpMessageConverters(){ 
    	List<HttpMessageConverter<?>> converters = new ArrayList<>();
    	converters.add(new MappingJackson2HttpMessageConverter());
    	return converters;
    }

    @Primary
    @Bean
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
    public IntegrationFlow loggingFlow() {
        return  IntegrationFlows
        		.from(loggingChannel())
        		.handle(m -> logMessage(m))
        		.get();
    }
    
    private void logMessage(Message<?> m) {
    	logger.debug(m.getPayload().toString());
	}

	@Bean
    public MessageChannel loggingChannel() { 
    	return MessageChannels
    				.publishSubscribe("loggingChannel" , defaultTreadPoolExecutor())
    				.get();
    }
    
    @Bean
    public List<ChannelInterceptor> channelInterceptorList(){ 
    	List<ChannelInterceptor> interceptorList = new ArrayList<>();
    	interceptorList.add(logWireTap());
    	return interceptorList;
    }
	
    @Bean
    public ThreadPoolTaskExecutor defaultTreadPoolExecutor() { 
    	ThreadPoolTaskExecutor tpe =  new ThreadPoolTaskExecutor();
    	tpe.setCorePoolSize(100);
    	tpe.setMaxPoolSize(Integer.MAX_VALUE);
    	return tpe;
    }
    
    
    /**
     * Bean reference a configuracao dos metodos de acesso e mimetype permitidos ao endpoint.
     * 
     * @return
     */
    @Bean
    public RequestMapping mapping() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET , HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mapping.setPathPatterns("/agreement");
		return mapping;
    }
    
    @Bean
	public HttpRequestHandlingMessagingGateway httpGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(mapping());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(channelConfiguration.conveniadasChannel());
		gateway.setReplyChannel(channelConfiguration.conveniadasResponseChannel());
		return gateway;
	}
    
    
    @Bean
    public ObjectMapper defaultObjectMapper() { 
    	return new ObjectMapper();
    }
    /**
     * Proposito - Transformar requisicao de entrada retornando resposta 200.
     * 
     * @param message
     * @return ObjectNode
     */
    @Transformer
	public ObjectNode mountMessageWithEventId(JsonMessage message , ObjectMapper objectMapper){ 
		ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.put("eventId", message.getEventId());
		return objectNode;
	}
    
    @Bean
    public IntegrationFlow flowRequestHttp(@Autowired ObjectMapper o) { 
    	return IntegrationFlows
    			.from(channelConfiguration.conveniadasChannel())
    			.enrichHeaders(h -> h.header("http_statusCode" , HttpStatus.OK))
                .<JsonMessage, ObjectNode>transform(p -> mountMessageWithEventId(p , o))
    			.channel(channelConfiguration.conveniadasResponseChannel())
    			.get();
    }
    
	@Autowired
	@Qualifier("errorChannel")
	private PublishSubscribeChannel errorChannel;
	
    
    @Bean
    public IntegrationFlow jsonMessageInputFlow() {
        return IntegrationFlows
        		.from(channelConfiguration.conveniadasChannel())
        		.<JsonMessage,JsonMessage>transform(p -> processImageMd5(p))
        		.gateway(mongoProperties.getChannels().getInputChannel())
        		.get();
    }


    private JsonMessage processImageMd5(final JsonMessage p) {
    	try { 
    			String md5Generated = md5Service.generateMd5(p.getImage());
    			if(md5Generated.equals(p.getImageMd5())) { 
    				p.getData().setMessage(SAME_MD5);
    			} else { 
    				p.getData().setMessage(NOT_SAME_MD5);
    				
    			}
    	}catch (NoSuchAlgorithmException e) { 
    		throw new BaseException(e);
    	}
		return p;
	}



	private void inspectMessage(Message<?> m) {
		 logger.info(m.toString());
	}
	
	
	public HttpRequestExecutingMessageHandler httpCallBackHandler() { 
		return Http.outboundGateway(new SpelExpressionParser().parseExpression("payload.callbackUrl"))
				.expectedResponseType(JsonNode.class)
				.messageConverters(httpMessageConverters().toArray(new HttpMessageConverter[httpMessageConverters().size()]))
				.httpMethod(HttpMethod.POST)
				.get();
	}
	

    public void logAsJson(Message<?> message , ObjectMapper objectMapper) {
    	JsonMessage payload = (JsonMessage) message.getPayload();
    	try {
			System.out.println(objectMapper.writeValueAsString(payload));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
    
    @Bean
    public IntegrationFlow flowRequestHttpCallback(@Autowired ObjectMapper o) { 
    	return IntegrationFlows
    				.from(requestChannelCallback())
    				.enrichHeaders(h -> h.header("http_statusCode" , HttpStatus.OK))
    				.channel("callBackResponseChannel")
    				.get();
    }
    
    @Bean
    public PublishSubscribeChannel requestChannelCallback() { 
    		return MessageChannels.publishSubscribe("callBackRequestChannel" , defaultTreadPoolExecutor()).get();
    }
}
