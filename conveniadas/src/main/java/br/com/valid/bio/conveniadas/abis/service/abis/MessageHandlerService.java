package br.com.valid.bio.conveniadas.abis.service.abis;

import static br.com.valid.bio.conveniadas.abis.service.abis.MessageEnricherService.REQUEST_TRANSFORMER;
import static br.com.valid.bio.conveniadas.abis.service.mongo.MongoBaseService.DOCUMENT_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.MessageHandler;
//import org.springframework.messaging.MessagingException;
import org.springframework.web.client.RestTemplate;

//import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.configuration.http.HttpResponseErrorHandler;
import br.com.valid.bio.conveniadas.abis.service.AuthorizationTokenBuilderService;
import br.com.valid.bio.conveniadas.abis.service.CacheKeyFactoryService;
import br.com.valid.bio.conveniadas.abis.service.HttpRequestHandlerCacheService;
import br.com.valid.bio.conveniadas.abis.service.mongo.MongoBaseService;
import br.com.valid.bio.conveniadas.abis.service.token.TokenLifeCycleService;
import br.com.valid.bio.conveniadas.abis.service.transformers.AgreementRequestTransformer;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.OauthTokenData;

@MessageEndpoint
public class MessageHandlerService {

//	private static final Logger logger = LoggerFactory.getLogger(MessageHandlerService.class);
	
	private static final String ACCESS_TOKEN = "accessToken";
	
	@Autowired
	private ChannelConfiguration channelConfiguration;
	
	@Autowired
	@Qualifier("httpMessageConverters")
	private List<HttpMessageConverter<?>> defaultHttpMessageConverters;

	@Autowired
	@Qualifier("defaultHttpHeaderMapper")
	private DefaultHttpHeaderMapper  defaultHttpHeaderMapper;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired 
	private HttpRequestHandlerCacheService handlerCache;
	
	@Autowired
	private CacheKeyFactoryService cacheKeyFactoryService;
	
	@Autowired
	private MongoBaseService mongoBaseService;
	
	@Autowired
	private AuthorizationTokenBuilderService tokenBuilderService;
	
	@Autowired
	private HttpResponseErrorHandler httpResponseErrorHandler;
	
	@Autowired
	private TokenLifeCycleService tokenLifeCycleService;
	
	public MessageHandlerService() {
	}
	
	@SuppressWarnings("unchecked")
	@ServiceActivator(inputChannel="mainHttpRequestChannel")
	public <T> void handleMessage(Message<AgreementRequest> requestTokenMessage){
		String documentId = requestTokenMessage.getHeaders().get(DOCUMENT_ID).toString();
		AgreementRequest payload = mongoBaseService.findById(documentId);
		MessageHeaders serviceRequestHeaders = prepareHeaders(requestTokenMessage.getHeaders() , tokenLifeCycleService.getTokenData());
		Message<AgreementRequest> requestMessage = MessageBuilder.withPayload(payload).copyHeaders(requestTokenMessage.getHeaders()).build();
		HttpRequestExecutingMessageHandler handler = httpHandlerAbis(requestMessage);
		configureAndStoreHandler(handler , requestMessage);
		AgreementRequestTransformer<T> transformer = (AgreementRequestTransformer<T>) requestTokenMessage.getHeaders().get(REQUEST_TRANSFORMER);
		T httpRequestPayload = transformer.apply(payload);
		handler.handleMessage(MessageBuilder
										.withPayload(httpRequestPayload)
										.copyHeaders(serviceRequestHeaders)
										.setHeader(DOCUMENT_ID, documentId)
										.setHeader(ACCESS_TOKEN,  tokenLifeCycleService.getTokenData())
										.build());
	}

	private MessageHeaders prepareHeaders(MessageHeaders headers , OauthTokenData tokenData) {
		Set<String> headersKeySet = headers.keySet();
		List<String> theList = new ArrayList<>(); 
		theList.add("service");
		theList.add("method");
		theList.add("transactionId");
		theList.add("endPoint");
		theList.add("id");
		theList.add("replyChannel");
		Map<String,Object> theMap = new HashMap<String,Object>();
		for(String headerStr : headersKeySet ) {
			if(theList.contains(headerStr)) { 
				theMap.put(headerStr , headers.get(headerStr));
			}
		}
		theMap.put("accept", "application/json");
		theMap.put("Authorization", tokenBuilderService.prepareToken(tokenData));
		theMap.put("Content-Type", "application/json-patch+json");
		return new MessageHeaders(theMap);
	}

	private void configureAndStoreHandler(HttpRequestExecutingMessageHandler handler, final Message<AgreementRequest> requestMessage) {
		handler.setApplicationContext(applicationContext);
		handler.setBeanFactory(applicationContext);
		handler.afterPropertiesSet();
		storeHandlerOnCache(handler , requestMessage);
	}

	private void storeHandlerOnCache(HttpRequestExecutingMessageHandler handler, final Message<AgreementRequest> requestMessage) {
		String handlerCacheKey = cacheKeyFactoryService.generateKey(requestMessage.getPayload());
		handlerCache.putIfAbsent(handlerCacheKey, handler);
	}

	private HttpRequestExecutingMessageHandler httpHandlerAbis(Message<AgreementRequest> requestMessage) {  
		String handlerCacheKey = cacheKeyFactoryService.generateKey(requestMessage.getPayload());
		return handlerCache.containsKey(handlerCacheKey)  ?  handlerCache.get(handlerCacheKey) : configureHandler(requestMessage);
	}

	private HttpRequestExecutingMessageHandler configureHandler(Message<AgreementRequest> requestMessage) {
		HttpRequestExecutingMessageHandler handler =  new HttpRequestExecutingMessageHandler(new SpelExpressionParser()
																									.parseExpression("headers.endPoint"),
																									 restTemplate(requestMessage)); 
			handler.setOutputChannel(channelConfiguration.mainHttpResponseChannel());
			handler.setExpectReply(true);
			handler.setMessageConverters(defaultHttpMessageConverters);
			handler.setHttpMethodExpression(new SpelExpressionParser().parseExpression("headers.method"));
			handler.setExpectedResponseTypeExpression(new SpelExpressionParser().parseExpression("@payloadClassResolverService.resolvePayloadClass(headers.service)")); 
			handler.setHeaderMapper(defaultHttpHeaderMapper);
			handler.setApplicationContext(applicationContext);
			handler.setBeanFactory(applicationContext);
			handler.setUriVariablesExpression(new SpelExpressionParser().parseExpression("@parameterPopulatorService.populatetKey(#root)"));
			handler.setErrorHandler(httpResponseErrorHandler);
			handler.afterPropertiesSet();
		return handler;
	}

	private RestTemplate restTemplate(Message<AgreementRequest> requestMessage) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(configureHttpFactory(requestMessage));
		return restTemplate;
	}


	//TODO: configurar timeout a partir das regras.
	private ClientHttpRequestFactory configureHttpFactory(Message<AgreementRequest> requestMessage) {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(10000);
		factory.setReadTimeout(15000);
		return factory;
	}
}
