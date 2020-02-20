package org.nanotek.controller.response;

import org.nanotek.EntityBase;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

public class EntityResponseBase <T extends EntityBase<?>> extends ResponseBase<T> {
	
	public EntityResponseBase(HttpStatus status) {
		super(status);
	}

	public EntityResponseBase(T body, HttpStatus status) {
		super(body, status);
	}

	public EntityResponseBase(MultiValueMap<String, String> headers, HttpStatus status) {
		super(headers, status);
	}

	public EntityResponseBase(T body, MultiValueMap<String, String> headers, HttpStatus status) {
		super(body, headers, status);
	}
	
	public static <T extends EntityBase<?>>  EntityResponseBase<T> fromEntity(T t , HttpStatus s) {
		return new EntityResponseBase<T>(t, s);
	}
	
}
