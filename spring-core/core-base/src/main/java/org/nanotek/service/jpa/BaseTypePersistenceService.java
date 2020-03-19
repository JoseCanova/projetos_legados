package org.nanotek.service.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.BaseType;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.nanotek.service.LongIdNameEntityService;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseTypePersistenceService<O extends BaseType<?> , B extends IdBaseRepository<O>> extends LongIdNameEntityService<O, B> {

	public BaseTypePersistenceService(B rep) {
		super(rep);
	}
	
	@Transactional
	public abstract Optional<O> findByTypeId(@NotNull Long typeId);
}
