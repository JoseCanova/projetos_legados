package br.com.valid.bio.conveniadas.abis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import br.com.valid.bio.conveniadas.abis.configuration.MessageProperties;
import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.model.response.BaseResponse;
import br.com.valid.bio.conveniadas.model.AgreementRequest;

/**
 * Proposito: Monitorar tempo de vida de uma requisição com o ABIS em andamento.
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class TransactionTimeoutMonitorService {

	@Value("${transactionDefaultTimeout}")
	private Long transactionDuration;
	
	@Autowired
	private MessageProperties messageProperties;
	
	@Autowired
	private ChannelConfiguration channelConfiguration;
	
	@ServiceActivator(inputChannel="mainInputChannel" , outputChannel="messageEnricherInputChannel")
	public Message<AgreementRequest> checkTransactionInitialization(Message<AgreementRequest> requestMessage) {
		Long transactionStartTime = System.currentTimeMillis();
		AgreementRequest ar = requestMessage.getPayload();
		ar.setTransactionStartTime(transactionStartTime);
		return MessageBuilder.withPayload(ar).copyHeaders(requestMessage.getHeaders()).build();
	}
	
	@ServiceActivator(inputChannel="mongoOutputChannel" , requiresReply="false")
	public void checkTransactionTimeout(Message<AgreementRequest> requestMessage) {
		Long currentTime = System.currentTimeMillis();
		AgreementRequest ar = requestMessage.getPayload();
		if(isExpired(currentTime , ar.getTransactionStartTime())) {
			BaseResponse expiredResponseMessage = prepareExpiredMessage();
			MessageChannel destination = channelConfiguration.mainHttpResponseChannel();
			new MessagingTemplate().convertAndSend(destination , expiredResponseMessage , requestMessage.getHeaders());
		}else { 
			MessageChannel destination = channelConfiguration.mainHttpRequestChannel();
			new MessagingTemplate().convertAndSend(destination , requestMessage.getPayload() , requestMessage.getHeaders());
		}
	}

	private boolean isExpired(Long currentTime, Long transactionStartTime) {
		return currentTime - transactionStartTime     > transactionDuration;
	}

	private BaseResponse prepareExpiredMessage() {
		BaseResponse br = new BaseResponse();
		br.setControlId("A-0001");
		br.setErrorCode("A-0001");
		br.setErrorMessage(messageProperties.getRequestExpired());
		return br;
	}
}
