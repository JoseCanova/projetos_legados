package br.com.valid.bio.conveniadas.abis.service.mongo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.support.MessageBuilder;

import br.com.valid.bio.conveniadas.model.AgreementRequest;

/**
 * Proposito, conjunto de operacoes mongodb baseadas no padrao Service Activator, 
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class MongoBaseService {

	public static final String DOCUMENT_ID = "document_id";

	@Autowired
	private MongoOperations mongoOperations;

	public MongoBaseService() {}

	@ServiceActivator(inputChannel="mongoInputChannel" , outputChannel="mongoOutputChannel")
	public  <T extends AgreementRequest> Message<T> baseInsertGateway(final Message<T> requestMessage) { 
		T payload = requestMessage.getPayload();
		if(!Optional.ofNullable(payload.getMongoId()).orElse("").isEmpty()) { 
			save(payload);
		}else {
			insert(payload);
		}
		return MessageBuilder
				.withPayload(payload)
				.copyHeaders(requestMessage.getHeaders())
				.setHeader(DOCUMENT_ID, payload.getMongoId())
				.build();
	}


	@ServiceActivator(inputChannel="httpAbisErrorMessageHandlerChannel" , outputChannel="errorHandlerOutputChannel")
	public  Message<AgreementRequest> errorMessageGateway(final Message<MessageHandlingException> requestMessage){ 
		MessageHandlingException payload = requestMessage.getPayload();
		Message<?> originalMessage = payload.getFailedMessage();
		String documentId = originalMessage.getHeaders().get(DOCUMENT_ID).toString();
		AgreementRequest agreementPayload = findAndRemoveMessage(documentId);
		return MessageBuilder
				.withPayload(agreementPayload)
				.copyHeaders(originalMessage.getHeaders())
				.build();
	}

	
	public void insert(AgreementRequest document) { 
		mongoOperations.insert(document);
	}
	
	public void save (AgreementRequest document) { 
		mongoOperations.save(document);
	}
	
	public  AgreementRequest findById(final String documentId){ 
		return mongoOperations.findById(documentId, AgreementRequest.class);
	}

	public AgreementRequest findAndRemoveMessage(String documentId){
		AgreementRequest message = findById(documentId);
		removeMessageFromDb(message);
		return message;
	}

	public <T extends AgreementRequest> void removeMessageFromDb(T document) {
		mongoOperations.remove(document);
	}
	
	public void removeMessageFromDb(String documentId){
		AgreementRequest message = findById(documentId);
		if (message !=null) {
			removeMessageFromDb(message);
		}
	}

}
