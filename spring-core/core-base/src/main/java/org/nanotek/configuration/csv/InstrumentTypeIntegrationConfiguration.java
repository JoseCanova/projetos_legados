package org.nanotek.configuration.csv;

import org.nanotek.JsonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties
public class InstrumentTypeIntegrationConfiguration {

	@Value("${server.port}")
	private String serverPort;

	@Value("${csv-endpoint.instrument-type}${csv-endpoint.next}")
	private String nexEndpoint;
	
	public InstrumentTypeIntegrationConfiguration() {
	}
	
	@Bean
	@Qualifier(value="baseRestTemplate")
	RestTemplate baseRestTemplate() { 
		RestTemplate restTemplate = new RestTemplate(); 
		return restTemplate;
	}
	
	@Bean
	HttpRequestExecutingMessageHandler csvNextMessageHandler
	(@Autowired @Qualifier("baseRestTemplate") RestTemplate baseTemplate) {
		String uriLocation = new StringBuilder()
				.append("http://127.0.0.1")
				.append(":")
				.append(serverPort)
				.append(nexEndpoint).toString();
		return new HttpRequestExecutingMessageHandler(uriLocation , baseTemplate);
	}
	
	@Bean
    RequestMapping mapping() { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(new HttpMethod[] {HttpMethod.GET, HttpMethod.POST});
		mapping.setConsumes(MediaType.APPLICATION_JSON_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_VALUE);
		mapping.setPathPatterns("/init");
		return mapping;
    }
    
	@Bean
	@Qualifier("startChannel")
	MessageChannel startChannel() {
		return new DirectChannel();
	}
	
	@Bean
	@Qualifier("responseChannel")
	MessageChannel responseChannel() {
		return new DirectChannel();
	}
	
    @Bean
    @Qualifier("httpGate")
	public HttpRequestHandlingMessagingGateway httpGate() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(mapping());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(startChannel());
		gateway.setReplyChannel(responseChannel());
		return gateway;
	}

    @Bean
	public IntegrationFlow flowRequestHttp() { 
		return IntegrationFlows
				.from(startChannel())
				.channel(responseChannel())
				.get();
	}
}