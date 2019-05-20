package br.com.valid.bio.conveniadas.abis.service.abis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.exception.AbisRuntimeException;
import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;
import br.com.valid.bio.conveniadas.abis.service.PayloadClassResolverService;
import br.com.valid.bio.conveniadas.abis.service.mongo.MongoBaseService;

@MessageEndpoint
public class EmptyResponseHandlerService {

	@Autowired
	MongoBaseService mongoBaseService;
	
	@Autowired
	@Qualifier("payloadClassResolverService")
	PayloadClassResolverService payloadClassResolverService;
	
	@Autowired 
	ChannelConfiguration channelConfiguration;
	
	@ServiceActivator(inputChannel="emptyResponseDestinationChannel" , outputChannel="prepareResponseChannel")
	public <T extends AbstractResponse> Message<?> handleEmptyResponse(Message<ResponseBody> responseMessage) {
		String service = responseMessage.getHeaders().get("service").toString();
		Class<?> payloadClass = payloadClassResolverService.resolvePayloadClass(service);
		Object response = instantiate(payloadClass);
		return MessageBuilder.withPayload(response).copyHeaders(responseMessage.getHeaders()).build();
	}
	
	private  Object instantiate(Class <?> clazz) { 
				try {
					return clazz.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					throw new AbisRuntimeException(e);
				}
	}
	
}
