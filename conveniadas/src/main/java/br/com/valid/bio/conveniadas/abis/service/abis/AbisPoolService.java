package br.com.valid.bio.conveniadas.abis.service.abis;

import static br.com.valid.bio.conveniadas.abis.service.mongo.MongoBaseService.DOCUMENT_ID;
import static br.com.valid.bio.utils.AgreementUtils.findAgreementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.model.response.BaseResponse;
import br.com.valid.bio.conveniadas.abis.service.mongo.MongoBaseService;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.agreement.Service;
import br.com.valid.bio.utils.MessageUtils;

/**
 * Proposito, recuperar mensagem original do Mongo/ alterando o metodo no dados do serviço.
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class AbisPoolService {

	@Autowired
	private ChannelConfiguration channelConfiguration; 
	
	@Autowired
	private MongoBaseService mongoBaseService;
	
	public AbisPoolService() {}
	
	@ServiceActivator(inputChannel="mongoPoollerRequestChannel")
	public <T extends BaseResponse> void retrieveMessageFromMongo(Message<T> message){ 
		String documentId =  message.getHeaders().get(DOCUMENT_ID).toString();
		AgreementRequest agreementRequest = mongoBaseService.findById(documentId);
		verifyAndChangeRequestMethod(agreementRequest);
		new MessagingTemplate().convertAndSend(channelConfiguration.messageEnricherInputChannel(), agreementRequest , MessageUtils.getMessageHeaders(message.getHeaders()));
	}

	private void verifyAndChangeRequestMethod(AgreementRequest agreementRequest) {
		Service service = findAgreementService(agreementRequest);
		if("PUT".equals(agreementRequest.getMethod())) {
			agreementRequest.setMethod("GET");
			service.setMethod("GET");
		}
		
	}
}
