package org.nanotek.controller.entity;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.EntityBase;
import org.nanotek.controller.EntityServiceResponseBase;
import org.nanotek.controller.response.EntityResponseBase;
import org.nanotek.controller.response.IterableResponseEntity;
import org.nanotek.controller.response.ResponseBase;
import org.nanotek.service.jpa.BasePersistenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface EntityResponseController < E extends EntityBase<K> , K extends Serializable >
			extends EntityServiceResponseBase<ResponseBase<E>, E, K , BasePersistenceService<E,K>> {


	BasePersistenceService<E,K> getBaseService();

	@Override
	@GetMapping("/{id}")
	default EntityResponseBase<E> get(@PathVariable(value="id") K  id)  {
		Optional<E> opt = getBaseService().findById(id);
		HttpStatus status =  opt.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		E body = opt.isPresent() ? opt.get() : null;
		return EntityResponseBase.fromEntity(body , status);
	}
	
	@GetMapping("/findAll")
	default IterableResponseEntity<?, E> findAll(){ 
		return IterableResponseEntity.fromIterable(getBaseService().findAll() , HttpStatus.OK);
	}
	
}
