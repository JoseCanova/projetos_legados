package org.nanotek.controller.response.entity;

import org.nanotek.beans.Artist;
import org.nanotek.controller.response.EntityResponseBase;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

public class ArtistResponse extends EntityResponseBase<Artist>{
	public ArtistResponse(HttpStatus status) {
		super(status);
	}

	public ArtistResponse(Artist body, HttpStatus status) {
		super(body, status);
	}

	public ArtistResponse(MultiValueMap<String, String> headers, HttpStatus status) {
		super(headers, status);
	}

	public ArtistResponse(Artist body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(body, headers, status);
	}
}