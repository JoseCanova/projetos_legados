package br.com.valid.bio.conveniadas.abis.service.transformers.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;
import br.com.valid.bio.conveniadas.abis.model.response.ErrorResponse;
import br.com.valid.bio.conveniadas.model.RequestBase;
import br.com.valid.bio.conveniadas.model.response.v2.ErrorMessage;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseBase;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseData;

public abstract class ErrorResponseTransformer <U extends RequestBase , S extends ErrorResponse , T extends ResponseBase> implements ResponseTransformer<U,S,T>{

	protected boolean containErrors(AbstractResponse baseResponse) {
		return !Optional.ofNullable(baseResponse.getErrorCode()).orElse("").isEmpty();
	}
	
	protected ErrorMessage mountErrorMessage(AbstractResponse baseResponse) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrCode(500);
		errorMessage.setMessage(baseResponse.getErrorMessage());
		return errorMessage;
	}
	
	protected ResponseData crateResponseDataError(ErrorMessage error) {
		List<ErrorMessage> errorsList = new ArrayList<>();
		errorsList.add(error);
		ResponseData responseData = new ResponseData();
		responseData.setErrors(errorsList);
		return responseData;
	}
	
}
