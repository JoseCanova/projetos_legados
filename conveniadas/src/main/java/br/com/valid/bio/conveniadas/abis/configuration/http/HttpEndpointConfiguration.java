package br.com.valid.bio.conveniadas.abis.configuration.http;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
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

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.model.enroll.EnrollRequest;
import br.com.valid.bio.conveniadas.abis.service.AgreementRequestErrorHttpTransformer;
import br.com.valid.bio.conveniadas.abis.service.MethodResolverService;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseData;

/**
 * Propósito, classe de configuracao para EndPoint HTTP
 * @author jose.canova
 *
 */
@Configuration
public class HttpEndpointConfiguration {

	
	@Value("${defaultRequestTimeout}")
	private int defaultRequestTimeout;
	
	@Value("${defaultResponseTimeout}")
	private int defaultResponseTimeout;
	
	@Value("${tokenUri}")
	private String tokenUri;
	
	@Autowired
	private HttpProperties httpProperties;
	
	@Autowired
	@Qualifier("methodResolverService")
	private MethodResolverService methodResolverService;

	@Autowired
	private ChannelConfiguration channelConfiguration;
	
	
	public HttpEndpointConfiguration() {
	}
	
	/**
	 * @deprecated Implementação desnecessária.
	 * @return
	 */
	@Bean
	@Qualifier(value="httpMethods")
	@DependsOn(value={"httpProperties" , "methodResolverService"})
	public HttpMethod[] httpMethods() {
		Set<String> methods = new HashSet<>();
		List<HttpMethod> httpMethods = new ArrayList<>();
		httpProperties.getEndPoints().stream().forEach(c -> c.getMethods().stream().forEach(m ->methods.add(m)));
		methods.stream().forEach(m -> httpMethods.add(methodResolverService.resolveMethod(m)));
		return httpMethods.toArray(new HttpMethod[httpMethods.size()]);
	}
	
	
	@Bean
	@Qualifier(value="httpEndpoints")
	@DependsOn(value={"httpProperties"})
	public String[] httpEndpoints() {
		List<String> httpEndpoints = httpProperties.getEndPoints().stream().map(c -> c.getUri()).collect(Collectors.toList());
		return httpEndpoints.toArray(new String[httpEndpoints.size()]);
	}
	
    /**
     * Bean reference a configuracao dos metodos de acesso e mimetype permitidos ao endpoint.
     * 
     * @return
     */
    @Bean(name="abisRequestMapping")
    @Qualifier(value="abisRequestMapping")
    @DependsOn("httpEndpoints")
    public RequestMapping abisRequestMapping(@Autowired @Qualifier("httpMethods") HttpMethod[] httpMethods,
    										 @Autowired @Qualifier("httpEndpoints") String[] httpEndpoints) { 
		RequestMapping mapping = new RequestMapping();
		mapping.setMethods(HttpMethod.POST);
		mapping.setConsumes(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mapping.setProduces(MediaType.APPLICATION_JSON_UTF8_VALUE);
		mapping.setPathPatterns("/abis");
		return mapping;
    }
    
    @Bean
    @Qualifier("abisRequestMessagingGateway")
	public HttpRequestHandlingMessagingGateway abisRequestMessagingGateway(
			@Autowired @Qualifier("mainInputChannel") MessageChannel inputChannel ,  
			@Autowired @Qualifier("mainOutputChannel") MessageChannel outputChannel,
			@Autowired @Qualifier("abisRequestMapping") RequestMapping abisRequestMapping) {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(abisRequestMapping);
		gateway.setRequestPayloadTypeClass(AgreementRequest.class);
		gateway.setRequestTimeout(defaultRequestTimeout);
		gateway.setReplyTimeout(defaultResponseTimeout);
		gateway.setRequestChannel(inputChannel);
		gateway.setReplyChannel(outputChannel);
		gateway.setReplyTimeout(90000);
		return gateway;
	}
    

	@Bean
    public IntegrationFlow mainHttpIntegrationErrorFlow(@Autowired @Qualifier("errorHandlerOutputChannel") MessageChannel errorHandlerOutputChannel,
    											   @Autowired @Qualifier("mainOutputChannel") MessageChannel outputChannel,
    											   @Autowired AgreementRequestErrorHttpTransformer transformer) { 
    	return IntegrationFlows
    			.from(errorHandlerOutputChannel)
    			.<AgreementRequest,ResponseData>transform(m -> transformer.mountResponseHttpErrorMessage(m))
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
	public ObjectNode mountMessageWithEventId(AgreementRequest message , ObjectMapper objectMapper){ 
		ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.put("eventId", message.getEventId());
		return objectNode;
	}
    
    @Bean
    @Qualifier("abisTokenRequestMessagingGateway")
	public HttpRequestHandlingMessagingGateway abisTokenRequestMessagingGateway() {
    	RequestMapping enrollMapping = new RequestMapping();
    	enrollMapping.setMethods(new HttpMethod[] {HttpMethod.POST});
    	enrollMapping.setPathPatterns(tokenUri);
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(enrollMapping);
		gateway.setRequestPayloadTypeClass(String.class);
		gateway.setRequestTimeout(defaultRequestTimeout);
		gateway.setReplyTimeout(defaultResponseTimeout);
		gateway.setRequestChannel(channelConfiguration.mainEnrollDummyInputChannel());
		gateway.setReplyChannel(channelConfiguration.mainEnrollDummyOutputChannel());
		return gateway;
	}
    
    
    
    /**
     * 
     * Endpoints de configuração para testes dos objetos de resposta ABIS (sucesso e falha).
     * 
     */
    @Bean
    @Qualifier("abisTestEnrollRequestMessagingGateway")
	public HttpRequestHandlingMessagingGateway abisTestEnrollRequestMessagingGateway() {
    	RequestMapping enrollMapping = new RequestMapping();
    	enrollMapping.setMethods(new HttpMethod[] {HttpMethod.PUT});
    	enrollMapping.setPathPatterns(new String [] {"/abis/facial/enrollment/{transactionKey}" , "/abis/facial/verify/{transactionKey}"});
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
		gateway.setRequestMapping(enrollMapping);
		gateway.setRequestPayloadTypeClass(EnrollRequest.class);
		gateway.setRequestTimeout(defaultRequestTimeout);
		gateway.setReplyTimeout(defaultResponseTimeout);
		gateway.setRequestChannel(channelConfiguration.mainEnrollDummyInputChannel());
		gateway.setReplyChannel(channelConfiguration.mainEnrollDummyOutputChannel());
		return gateway;
	}
    
}

