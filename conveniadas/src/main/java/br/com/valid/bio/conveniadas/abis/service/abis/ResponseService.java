package br.com.valid.bio.conveniadas.abis.service.abis;

import static br.com.valid.bio.conveniadas.abis.service.mongo.MongoBaseService.DOCUMENT_ID;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import br.com.valid.bio.conveniadas.abis.configuration.channel.ChannelConfiguration;
import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;
import br.com.valid.bio.conveniadas.abis.model.response.BaseResponse;
import br.com.valid.bio.conveniadas.abis.model.subject.SubjectResponse;
import br.com.valid.bio.conveniadas.abis.service.mongo.MongoBaseService;
import br.com.valid.bio.conveniadas.abis.service.transformers.response.BaseResponseTransformer;
import br.com.valid.bio.conveniadas.abis.service.transformers.response.SubjectResponseAgreementTransformer;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseData;


/**
 * Proposito montagem da response para saida HTTP - router.
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class ResponseService {

	@Autowired
	private ChannelConfiguration channelConfiguration;
	
	@Autowired
	private MongoBaseService mongoBaseService;
	
	 @Autowired 
	 @Qualifier("subjectResponseAgreementTransformer") 
	 private SubjectResponseAgreementTransformer subjectResponseTransfomer;
	 
	 @Autowired 
	 @Qualifier("baseResponseTransformer") 
	 private BaseResponseTransformer baseResponseTransfomer;
	 
	
	@Router(inputChannel="prepareResponseChannel" , defaultOutputChannel="loggingChannel")
	public Collection<MessageChannel> routeResponseTransformer(Message<AbstractResponse> responseMessage){ 
		Collection<MessageChannel> channels = new ArrayList<>();
		MessageChannel channel = null;
		AbstractResponse response = responseMessage.getPayload();
		if (response instanceof BaseResponse) { 
			channel = channelConfiguration.routeBaseResponseChannel();
		}else if (response instanceof SubjectResponse) { 
			channel = channelConfiguration.routeSubjectResponseChannel();
		}
		channels.add(channel);
		return channels;
	}
	
	
	@ServiceActivator(inputChannel="routeSubjectResponseChannel" , outputChannel="mainOutputChannel")
	public Message<ResponseData> mountSubjectResponse(Message<SubjectResponse> responseMessage){ 
		String documentId = responseMessage.getHeaders().get(DOCUMENT_ID).toString();
		AgreementRequest agreementRequest = mongoBaseService.findById(documentId);
		SubjectResponse response = responseMessage.getPayload();
		ResponseData ar = null;
		ar = subjectResponseTransfomer.apply(agreementRequest, response);
		return MessageBuilder.withPayload(ar).copyHeaders(responseMessage.getHeaders()).build();
	}
	
	@ServiceActivator(inputChannel="routeBaseResponseChannel" , outputChannel="mainOutputChannel")
	public Message<ResponseData> mountResponse(Message<BaseResponse> responseMessage){ 
		String documentId = responseMessage.getHeaders().get(DOCUMENT_ID).toString();
		AgreementRequest agreementRequest = mongoBaseService.findById(documentId);
		BaseResponse response = responseMessage.getPayload();
		ResponseData ar = null;
		ar = baseResponseTransfomer.apply(agreementRequest, response);
		return MessageBuilder.withPayload(ar).copyHeaders(responseMessage.getHeaders()).build();
	}

	@ServiceActivator(inputChannel="mainOutputChannel")
	public void removeMongoDocument(Message<BaseResponse> responseMessage){ 
		String documentId = responseMessage.getHeaders().get(DOCUMENT_ID).toString();
		mongoBaseService.removeMessageFromDb(documentId);
	}
	
}
