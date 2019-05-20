package br.com.valid.bio.conveniadas.abis.service.abis;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.model.TransactionStateEnum;
import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;

/**
 * Proposito : avalia o estado da transacao, se nao for completada, 
 * executa o pooling de chamada de serviço.
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class TransactionStateService {

	
	@Autowired
	private ChannelConfiguration channelConfiguration; 
	
	
	@Router(inputChannel="transactionStateChannel")
	public <T extends AbstractResponse> Collection<MessageChannel> verifyResponseTransactionState(Message<T> message){
		T payload = message.getPayload();
		Collection<MessageChannel> responseChannels = new ArrayList<>();
		MessageChannel channel = verifyTransactionState(payload.getTransactionState());
		responseChannels.add(channel);
		return responseChannels;// MessagingTemplate().convertAndSend(channel, payload, MessageUtils.getMessageHeaders(message.getHeaders()));
	}


	private MessageChannel verifyTransactionState(TransactionStateEnum transactionState) {
		
		MessageChannel dispatchChannel = null;
		
		switch (transactionState) {
		case DONE:
			dispatchChannel = channelConfiguration.prepareResponseChannel();
			break;
		case CANCELED:
			dispatchChannel = channelConfiguration.transactionCanceledChannel();
			break;
		default:
			dispatchChannel = channelConfiguration.poollerChannel();
			break;
		}
			
		return dispatchChannel;
	}
	
}
