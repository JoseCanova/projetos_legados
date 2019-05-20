package br.com.valid.bio.conveniadas.abis.service.abis;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.google.common.base.Optional;

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;

/**
 * Proposito verifica mensagem de resposta servico ABIS, 
 * Se resposta for tipo base, verifica se possui erro, gera mensagem de erro, recupera o agreement request 
 * para popular com mensagem de erro do sistema.
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class ResponseMessageHandlerService {
	
	@Autowired
	private ChannelConfiguration channelConfiguration;

	@Router(inputChannel="mainHttpResponseChannel" , defaultOutputChannel="loggingChannel")
	public <T> Collection<MessageChannel> handleResponseMessage(Message<T> message) { 
		MessageChannel destination = null;
		Collection<MessageChannel> destinations = new ArrayList<>();
		T payload = message.getPayload();
		boolean hasError = checkErrorMessage(payload);
		if(hasError && payload instanceof AbstractResponse) { 
			destination = channelConfiguration.responseErrorOutputChannel();
		}else if (payload instanceof AbstractResponse){ 
			destination = channelConfiguration.transactionStateChannel();
		}else if (payload instanceof ResponseEntity) { 
			destination = channelConfiguration.emptyResponseDestinationChannel();
		}
		destinations.add(destination);
		return destinations;
	}

	private <T> boolean checkErrorMessage(T payload) {
		boolean hasError = false;
		if (payload instanceof AbstractResponse) { 
			hasError = verifyErrorOnResponse((AbstractResponse)payload);
		}else { 
			hasError = true;
		}
		return hasError;
	}

	private <T extends AbstractResponse> boolean verifyErrorOnResponse(T payload) {
		return NotEmptyString(payload.getErrorCode());
	}

	private boolean NotEmptyString(String string) {
		return !Optional.fromNullable(string).or("").isEmpty();
	}

	
}
