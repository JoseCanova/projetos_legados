package br.com.valid.bio.conveniadas.abis.configuration.dispatcher;

import java.util.List;

import org.bson.internal.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import br.com.valid.bio.conveniadas.model.OauthTokenData;

/**
 * 
 * @author jose.canova
 */
@Configuration
public class DispatcherConfiguration {

	@Value("${clientId}")
	private String clientId; 

	@Value("${clientSecret}")
	private String clientSecret;

	@Value("${tokenServerUrl}")
	private String tokenServerUrl;

	@Value("${tokenUri}")
	private String tokenUri;

	@Autowired
	@Qualifier("httpMessageConverters")
	private List<HttpMessageConverter<?>> defaultHttpMessageConverters;

	@Autowired
	@Qualifier("defaultHttpHeaderMapper")
	private DefaultHttpHeaderMapper  defaultHttpHeaderMapper;

	@Autowired 
	private DispatcherProperties dispatcherProperties;

	public DispatcherConfiguration() {
	}

	@Bean(name="httpHandlerLogon")
	@Qualifier(value="httpHandlerLogon")
	public HttpRequestExecutingMessageHandler httpHandlerLogon() {  
		HttpRequestExecutingMessageHandler handler =  new HttpRequestExecutingMessageHandler(new StringBuilder().append(tokenServerUrl).append(tokenUri).toString()); 
		handler.setOutputChannelName("accessTokenOutputChannel");
		handler.setExpectReply(true);
		handler.setMessageConverters(defaultHttpMessageConverters);
		handler.setHttpMethod(HttpMethod.POST);
		handler.setExpectedResponseType(OauthTokenData.class); 
		handler.setHeaderMapper(defaultHttpHeaderMapper);
		return handler;
	}

	@Bean
	@Qualifier("OAuthAuthorization")
	public String base64Authorization() { 
		return "Basic " + Base64.encode(new StringBuilder().append(clientId).append(":").append(clientSecret).toString().getBytes());
	}

	@Bean
	public IntegrationFlow dispatcherHttpClientCredentials(@Autowired @Qualifier("accessTokenChannel") MessageChannel accessTokenChannel , 
															@Autowired @Qualifier("httpHandlerLogon") MessageHandler handler,
															@Autowired @Qualifier("OAuthAuthorization") String base64Authorization) {
		return IntegrationFlows
				.from(accessTokenChannel)
				.headerFilter(dispatcherProperties.getFilterHeaderList().toArray(new String[dispatcherProperties.getFilterHeaderList().size()]))
				.enrichHeaders(h -> h.header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE))
				.enrichHeaders(h -> h.header("Authorization", base64Authorization))
				.handle(handler)
				.get();
	}

	@Bean
	public MessageChannel loggerChannel() { 
		return MessageChannels.direct("localLogChannel").get();
	}

//	@Bean
//	public IntegrationFlow loggingFlow() {
//		return  IntegrationFlows
//				.from("localLogChannel")
//				.handle(m -> logMessage(m))
//				.get();
//	}
//
//	private void logMessage(Message<?> m) {
//		logger.debug(m.getPayload().toString());
//	}

}
