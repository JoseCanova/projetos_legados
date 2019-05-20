package br.com.valid.bio.conveniadas.abis.service.transformers.response;

import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;
import br.com.valid.bio.conveniadas.model.RequestBase;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseData;

public abstract class AbstractBaseResponseTransformer<U extends RequestBase , S extends AbstractResponse> extends ErrorResponseTransformer<U,S,ResponseData>{
	
	
	@Override
	public ResponseData apply(U agreementRequest, S baseResponse) {
		ResponseData response = null; 
		if (containErrors(baseResponse)) { 
			response =  crateResponseDataError(mountErrorMessage(baseResponse));
		}else { 
			response = populateSuccessfulResponse(agreementRequest , baseResponse);
		}
		return response;
	}
	
	abstract ResponseData populateSuccessfulResponse(U agreementRequest, S baseResponse);

}
