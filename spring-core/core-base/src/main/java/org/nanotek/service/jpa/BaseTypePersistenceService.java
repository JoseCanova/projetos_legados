package org.nanotek.service.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.BaseType;
import org.nanotek.repository.jpa.BaseTypeRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseTypePersistenceService<O extends BaseType , B extends BaseTypeRepository<O>> extends LongIdNameEntityService<O, B> {

	public BaseTypePersistenceService(B rep) {
		super(rep);
	}
	
	@Transactional
	public Optional<O> findByTypeId(@NotNull Long typeId){ 
		return baseRepository.findByTypeId(typeId);
	}
}
