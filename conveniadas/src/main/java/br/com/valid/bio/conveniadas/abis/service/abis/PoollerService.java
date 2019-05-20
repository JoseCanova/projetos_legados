package br.com.valid.bio.conveniadas.abis.service.abis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import br.com.valid.bio.conveniadas.abis.model.response.BaseResponse;
import br.com.valid.bio.conveniadas.abis.service.ThreadHolder;

/**
 * Proposito: executar a parada para chamada do serviço GET para recuperação dos dados.
 * @author jose.canova
 *
 */
@MessageEndpoint
public class PoollerService {

	@Value("${requestInterval}")
	private long requestInterval;
	
	@Autowired
	private ThreadHolder threadHolder;
	
	//TODO: mover canal de saida para o timeout check.
	@ServiceActivator(inputChannel="poollerChannel" , outputChannel="mongoPoollerRequestChannel")
	public <T extends BaseResponse> Message<T> poollerService(Message<T> message) {
		threadHolder.hold(requestInterval);
		return MessageBuilder.withPayload(message.getPayload()).copyHeaders(message.getHeaders()).build();
	}
	
}
