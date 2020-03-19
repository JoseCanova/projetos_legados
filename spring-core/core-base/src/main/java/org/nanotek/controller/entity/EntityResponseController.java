package org.nanotek.controller.entity;

import java.util.Optional;

import org.nanotek.EntityBase;
import org.nanotek.controller.response.IdBaseResponseBase;
import org.nanotek.controller.response.IterableResponseEntity;
import org.nanotek.service.jpa.BasePersistenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EntityResponseController < E extends EntityBase<Long> , S extends BasePersistenceService<E, ?>>{


	BasePersistenceService<E,?> getBaseService();

	@GetMapping("/{id}")
	default IdBaseResponseBase<E> get(@PathVariable(value="id") Long  id)  {
		Optional<E> opt = getBaseService().findById(id);
		HttpStatus status =  opt.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		E body = opt.isPresent() ? opt.get() : null;
		return IdBaseResponseBase.fromEntity(body , status);
	}
	
	@GetMapping("/findAll")
	default IterableResponseEntity<?, E> findAll(){ 
		return IterableResponseEntity.fromIterable(getBaseService().findAll() , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	default IdBaseResponseBase<E> post(@RequestBody E e){ 
		E ei = getBaseService().saveAndFlush(e);
		return IdBaseResponseBase.fromEntity(ei ,  HttpStatus.OK );
	}
	
}
