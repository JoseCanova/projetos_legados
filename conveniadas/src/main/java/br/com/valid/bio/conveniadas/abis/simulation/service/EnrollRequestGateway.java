package br.com.valid.bio.conveniadas.abis.simulation.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.model.TransactionStateEnum;
import br.com.valid.bio.conveniadas.abis.model.enroll.EnrollRequest;
import br.com.valid.bio.conveniadas.abis.model.enroll.EnrollResponse;

/**
 * @deprecated
 * @author jose.canova
 *
 */
@MessageEndpoint
public class EnrollRequestGateway {

	@Autowired
	ChannelConfiguration channelConfiguration;
	
	public EnrollRequestGateway() {
	}
	
	//TODO: preparar methodos de verificaçao de testes para o request..
	@ServiceActivator(inputChannel="mainEnrollDummyInputChannel" , outputChannel="mainEnrollDummyOutputChannel")
	public Message<?> processAndSimulateEnrollRequest(Message<EnrollRequest> requestMessage) {
		EnrollResponse enrollResponse = new EnrollResponse();
		EnrollRequest request = requestMessage.getPayload();
		enrollResponse.setTransactionState(TransactionStateEnum.DONE);
//		enrollResponse.setTransactionKey(requestMessage.getHeaders().get("transactionKey").toString());
		return MessageBuilder.withPayload(enrollResponse).copyHeaders(requestMessage.getHeaders()).build();
	}

}
