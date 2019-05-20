package br.com.valid.bio.conveniadas.abis.service.transformers.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.abis.model.response.BaseResponse;
import br.com.valid.bio.conveniadas.abis.model.response.Match;
import br.com.valid.bio.conveniadas.model.AgreementRequest;
import br.com.valid.bio.conveniadas.model.response.v2.Candidate;
import br.com.valid.bio.conveniadas.model.response.v2.Image;
import br.com.valid.bio.conveniadas.model.response.v2.ResponseData;

@Component
@Qualifier(value="baseResponseTransformer")
public class BaseResponseTransformer extends AgreementRequestResponseTransformer<BaseResponse>{

	@Override
	ResponseData populateSuccessfulResponse(AgreementRequest agreementRequest, BaseResponse baseResponse) {
		return populateResponseData(baseResponse);
	}

	private ResponseData populateResponseData(BaseResponse baseResponse) {
		ResponseData responseData = new ResponseData();
		List<Image> images = populateImages(baseResponse); 
		responseData.setFaceId(baseResponse.getImageKey());
		responseData.setImages(images);
		return responseData;
	}

	private List<Image> populateImages(BaseResponse baseResponse) {
		List<Image> images = new ArrayList<>();
		Image image = new Image (); 
		populateCandidates(baseResponse , image);
		images.add(image);
		return images;
	}

	private void populateCandidates(BaseResponse baseResponse , Image image) {
		List<Match> matches = baseResponse.getMatches();
		if (matches !=null) { 
			List<Candidate> candidates = new ArrayList<>();
			image.setCandidates(candidates);
			for (Match match : matches) { 
				Candidate candidate = new Candidate();
				candidate.setFaceId(match.getImageKey());
				candidate.setConfidence(Float.valueOf(match.getScore()));
				candidates.add(candidate);
			}
		}
	}

}
