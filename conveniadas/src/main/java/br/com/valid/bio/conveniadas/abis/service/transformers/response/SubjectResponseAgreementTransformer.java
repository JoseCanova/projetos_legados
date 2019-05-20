package br.com.valid.bio.conveniadas.abis.service.transformers.response;

import static br.com.valid.bio.conveniadas.abis.model.subject.SubjectResponse.FACES;
import static br.com.valid.bio.conveniadas.abis.model.subject.SubjectResponse.FINGERPRINTS;
import static br.com.valid.bio.conveniadas.abis.model.subject.SubjectResponse.TAGS;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.abis.model.subject.SubjectResponse;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseData;

@Component
@Qualifier(value="subjectResponseAgreementTransformer")
public class SubjectResponseAgreementTransformer extends AbstractBaseResponseTransformer<AgreementRequest , SubjectResponse>{

	public SubjectResponseAgreementTransformer() {}

	@Override
	ResponseData populateSuccessfulResponse(AgreementRequest agreementRequest, SubjectResponse baseResponse) {
		return populateResponseData(baseResponse);
	}

	private ResponseData populateResponseData(SubjectResponse baseResponse) {
		ResponseData responseData = new ResponseData();
		if(baseResponse.getTags()!=null) responseData.setAdditionalProperty(TAGS, baseResponse.getTags());
		if(baseResponse.getFingerprints()!=null) responseData.setAdditionalProperty(FINGERPRINTS, baseResponse.getFingerprints());
		if(baseResponse.getFaces() != null) responseData.setAdditionalProperty(FACES, baseResponse.getFaces());
		return responseData;
	}

}
