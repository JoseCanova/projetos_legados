package br.com.valid.bio.agreement.integration;

import br.com.valid.bio.agreement.integration.wrapper.AgreementRequestWrapper;
import br.com.valid.bio.agreement.integration.wrapper.JsonResponseWrapper;
import br.com.valid.bio.agreement.model.JsonMessage;
import br.com.valid.bio.agreement.model.partner.kairos.BaseResponse;
import br.com.valid.bio.agreement.model.rule.Agreement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Optional;

/**
 * Proposito, conjunto de operacoes mongodb baseadas no padrao Service Activator, 
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class KairosBaseService {
	
public static final String DOCUMENT_ID = "document_id";


	private static Logger logger = LoggerFactory.getLogger(KairosBaseService.class);

	@Autowired
	private MongoOperations mongoOperations;
	
	public KairosBaseService() {}
	

	//TODO: construir a mensagem de erro do sistema. chamadas http para o endpoint kairos.
	@ServiceActivator(inputChannel="errorMessageHandlerChannel", outputChannel = "nullChannel")
	public  Message<?> errorMessageGateway(final Message<MessagingException> requestMessage) {
			MessagingException payload = requestMessage.getPayload();
			AgreementRequestWrapper originalMessage = (AgreementRequestWrapper) payload.getFailedMessage().getPayload();
			logger.error("Error during process {} transaction {} and name {}", originalMessage.getService(), originalMessage.getTransaction(), originalMessage.getName());
			return MessageBuilder.withPayload(requestMessage.getPayload().getLocalizedMessage()).build();
	}

	//TODO: mover para boolean nativo do agreement.
	private void verifyRequiredAgreement(JsonMessage message, MessageHandlingException payload) {
		Agreement agreement = message.getData().getRule().getAgreements().get(0);
		if(Optional.ofNullable(agreement.getRequired()).orElse(false).equals(true)) { 
			message.getData().setMessage(payload.getMessage());
			message.getData().setStatus(500);
		}
	}

	private  <T extends BaseResponse> void transferResponseToJsonMessage(JsonMessage message, T baseResponse) {
		Agreement agreement = message.getData().getRule().getAgreements().get(0);
		agreement.setResponseData(baseResponse);
	}


	public JsonResponseWrapper formatResponse(Message<?> responseMessage) {

		JsonResponseWrapper responseWrapper = new JsonResponseWrapper();

		final String id = (String) Optional.ofNullable(responseMessage.getHeaders().get("idAgreement")).orElse("0");
		final Long transaction = (Long) Optional.ofNullable(responseMessage.getHeaders().get("transaction")).orElse(0l);
		responseWrapper.setId(id);
		responseWrapper.setTransaction(Long.valueOf(transaction));
		responseWrapper.setResponseData((BaseResponse) responseMessage.getPayload());
		return responseWrapper;
	}
}
