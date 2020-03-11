package org.nanotek.controller.response;

import java.util.Optional;

import org.nanotek.Base;
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
	
	public static <B extends EntityBase<?>>  EntityResponseBase<B> fromEntity(B t , HttpStatus s) {
		return new EntityResponseBase<B>(t, s);
	}
	
	public static <B extends EntityBase<?>>  EntityResponseBase<B> fromEntityBase(Optional<B> t , HttpStatus s) {
		return new EntityResponseBase<B>(t.isPresent() ? t.get() : null, s);
	}
	
}
