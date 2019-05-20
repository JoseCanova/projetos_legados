package br.com.valid.bio.conveniadas.abis.service.abis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import br.com.valid.bio.conveniadas.abis.configuration.http.ClientEndpointConfiguration;
import br.com.valid.bio.conveniadas.abis.configuration.http.HttpProperties;
import br.com.valid.bio.conveniadas.abis.service.KeyParameter;
import br.com.valid.bio.conveniadas.abis.service.key.KeyServiceFactory;
import br.com.valid.bio.conveniadas.abis.service.transformers.Transformer;
import br.com.valid.bio.conveniadas.model.AgreementRequest;

@MessageEndpoint
public class MessageEnricherService {

	public static final String TARGET_ENDPOINT = "endPoint";
	
	public static final String HTTP_METHOD = "method";
	
	public static final String TARGET_RESPONSE_CLASS = "responseClass";
	
	public static final String TRANSACTION_KEY = "transactionId";
	
	public static final String SERVICE = "service";
	
	public static final String REQUEST_TRANSFORMER = "requestTransformer";
	
	@Autowired
	private HttpProperties httpProperties;
	
	@Autowired
	private KeyServiceFactory keyServiceFactory;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public MessageEnricherService() {
	}

	@ServiceActivator(inputChannel="messageEnricherInputChannel" , outputChannel="messageEnricherOutputChannel")
	public  Message<AgreementRequest> enrichMessage(Message<AgreementRequest> requestMessage){ 
		AgreementRequest agreementRequest = requestMessage.getPayload();
		String methodStr = agreementRequest.getMethod();
		String endPointStr = prepareEndPoint(agreementRequest.getEndPoint());
		KeyParameter keyParameter = resolveKeyParameter(requestMessage);
		if(isEmpty(agreementRequest.getImageKey())) {
			String imageKeyStr = generateImageKey(); 
			agreementRequest.setImageKey(imageKeyStr);
		}
		Transformer<?,?> requestTransformer = resolveRequestTransformer(requestMessage);
		return MessageBuilder
				.withPayload(agreementRequest)
				.setHeader(TARGET_ENDPOINT, endPointStr)
				.setHeader(HTTP_METHOD, methodStr)
				.setHeader(TRANSACTION_KEY,  keyParameter)
				.setHeader(SERVICE, agreementRequest.getServiceName())
				.setHeader(REQUEST_TRANSFORMER, requestTransformer)
				.copyHeaders(filterHeaders(requestMessage.getHeaders()))
				.build();
	}

	private boolean isEmpty(String string) {
		return Optional.ofNullable(string).orElse("").isEmpty();
	}

	private Map<String, ?> filterHeaders(MessageHeaders headers) {
		List<String> headersToFilter = new ArrayList<>();
		Map<String, Object> headerMap = new HashMap<>();
		headersToFilter.add(TARGET_ENDPOINT);
		headersToFilter.add(HTTP_METHOD);
		headersToFilter.add(TRANSACTION_KEY);
		headersToFilter.add(SERVICE);
		headersToFilter.add(REQUEST_TRANSFORMER);
		
		headers.keySet().stream().forEach(m -> {if(!headersToFilter.contains(m)) headerMap.put(m, headers.get(m));});
		
		return headerMap;
	}

	private Transformer<?,?> resolveRequestTransformer(Message<AgreementRequest> requestMessage) {
		AgreementRequest payload = requestMessage.getPayload();
		String serviceNameStr = payload.getServiceName();
		ClientEndpointConfiguration endpoint = httpProperties.getEndPoints().stream().filter(m -> m.getName().equals(serviceNameStr)).findFirst().get();
		return (Transformer<?, ?>) applicationContext.getBean(endpoint.getRequestTransformer());
	}

	//TODO: Implementar cabeçalho para chaves geradas.
	private <T extends AgreementRequest> KeyParameter resolveKeyParameter(Message<T> requestMessage) {
		T payload = requestMessage.getPayload();
		String parameterId = null;
		if ("SUBJECTS".equals(payload.getServiceName())){ 
			parameterId = payload.getDocument();
		}else { 
			if(isEmpty(payload.getTransactionKey())) {
				parameterId = generateImageKey();
				payload.setTransactionKey(parameterId);
			}else { 
				parameterId = payload.getTransactionKey();
			}
		}
		String parameterName = resolveParameterName(requestMessage.getPayload().getEndPoint()).replace("{", "").replace("}", "");
		return new KeyParameter(parameterName , parameterId);
	}

	private String resolveParameterName(String endPoint) {
		String parameterName = Stream.of(endPoint.split("\\/")).filter(c ->verifyBrackets(c)).findFirst().get();
		return parameterName;
	}

	private boolean verifyBrackets(String component) {
		return component.contains("{");
	}

	private String prepareEndPoint(String endPoint) {
		String uri = String.join("/", Stream.of(endPoint.split("\\/")).skip(1).collect(Collectors.toList()));
		return new StringBuilder().append(httpProperties.getAbisClientScheme()).append("://").append(httpProperties.getAbisClientUrl()).append("/").append(uri).toString();
	}
	
	private String generateImageKey() {
		return  keyServiceFactory.getKey(UUID.class).toString();
	}
}
