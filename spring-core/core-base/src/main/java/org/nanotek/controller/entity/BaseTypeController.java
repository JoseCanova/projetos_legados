package org.nanotek.controller.entity;

import java.util.Optional;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.beans.entity.BaseType;
import org.nanotek.controller.response.EntityResponseBase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface BaseTypeController<E extends BaseType> extends EntityNameBaseResponseController<E> {
	
	@RequestMapping("/type_id/{type_id}")
	default EntityResponseBase<E> findByTypeId(@PathVariable(value="type_id") Long  id) {
		Optional<E> it = getBaseService().findByTypeId(id);
		return EntityResponseBase.fromEntityBase(it, HttpStatus.OK);
	}
}
