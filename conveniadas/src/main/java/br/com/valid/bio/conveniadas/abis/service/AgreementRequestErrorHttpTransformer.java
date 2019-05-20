package br.com.valid.bio.conveniadas.abis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.abis.configuration.MessageProperties;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.response.v2.ErrorMessage;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseData;

@Component
public class AgreementRequestErrorHttpTransformer {

	@Autowired
	private MessageProperties messageProperties; 
	
	public AgreementRequestErrorHttpTransformer() {}
	
	public ResponseData mountResponseHttpErrorMessage(AgreementRequest agreementRequest) {
    	ResponseData rd = new ResponseData();
    	List<ErrorMessage> errors = new ArrayList<>();
    	errors.add(new ErrorMessage(500 , messageProperties.getBadRequest()));
		rd.setErrors(errors);
    	return rd;
	}
	
}
