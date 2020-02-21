package org.nanotek.controller.response.entity;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.controller.response.EntityResponseBase;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

public class ArtistCreditResponse extends EntityResponseBase<ArtistCredit>{

	public ArtistCreditResponse(ArtistCredit body, HttpStatus status) {
		super(body, status);
	}

	public ArtistCreditResponse(ArtistCredit body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(body, headers, status);
	}

	public ArtistCreditResponse(HttpStatus status) {
		super(status);
	}

	public ArtistCreditResponse(MultiValueMap<String, String> headers, HttpStatus status) {
		super(headers, status);
	}

}
