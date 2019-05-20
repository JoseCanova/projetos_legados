package br.com.valid.bio.abis.configuration.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.messaging.MessageChannel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.valid.bio.abis.model.JsonMessage;

/**
 * Proprosito, classe de configuracao para EndPoint HTTP
 * @author jose.canova
 *
 */
@Configuration
public class HttpEndpointConfiguration {

	@Autowired
	private HttpProperties httpProperties;
	
	public HttpEndpointConfiguration() {
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
		mapping.setPathPatterns(httpProperties.getEndPoint());
		return mapping;
    }
    
    @Bean
    @Qualifier("abisRequestMessagingGateway")
	public HttpRequestHandlingMessagingGateway abisRequestMessagingGateway(
			@Autowired @Qualifier("mainInputChannel") MessageChannel inputChannel ,  @Autowired @Qualifier("mainOutputChannel") MessageChannel outputChannel) {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(mapping());
		gateway.setRequestPayloadTypeClass(JsonMessage.class);
		gateway.setReplyTimeout(10000);
		gateway.setRequestChannel(inputChannel);
		gateway.setReplyChannel(outputChannel);
		return gateway;
	}
    

    @Bean
    public IntegrationFlow mainHttpIntegrationFlow(@Autowired @Qualifier("mainInputChannel") MessageChannel inputChannel,
    											   @Autowired @Qualifier("mainOutputChannel") MessageChannel outputChannel,
    											   @Autowired ObjectMapper objectMapper) { 
    	return IntegrationFlows
    			.from(inputChannel)
    			.<JsonMessage , ObjectNode>transform(m -> mountMessageWithEventId(m , objectMapper))
    			.channel(outputChannel)
    			.get();
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
    
}
