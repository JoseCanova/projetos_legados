package br.com.valid.bio.abis.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import br.com.valid.bio.abis.model.JsonMessage;

@MessageEndpoint
public class RfbSplitterService {

	@Autowired
	RfbBiographicSelector rfbBiographicSelector;
	
	public RfbSplitterService() {
	}

	//TODO: otimizar metodo.
	@Transformer
	public  Message<JsonMessage> transform(final Message<JsonMessage> requestMessage){
		JsonMessage jsonMessage = requestMessage.getPayload();
		MessageBuilder<JsonMessage> builder = MessageBuilder.withPayload(requestMessage.getPayload());
		if (rfbBiographicSelector.accept(jsonMessage)) { 
			Map<String,Object> headers = generateSplittHeaders(requestMessage , 2);
			builder = builder.copyHeaders(headers);
		}else { 
			Map<String,Object> headers = generateSplittHeaders(requestMessage , 1);
			builder = builder.copyHeaders(headers);
		}
		return builder.copyHeaders(requestMessage.getHeaders()).build();
	}

	private Map<String,Object> generateSplittHeaders(Message<JsonMessage> requestMessage , Integer sequenceSize) {
		Map<String,Object> headers = new HashMap<String,Object>();
		headers.put(CORRELATION_ID, String.valueOf(System.nanoTime()));
		headers.put(SEQUENCE_SIZE, sequenceSize);
		return headers;
	}
	
}