package org.nanotek.service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.nanotek.IdBase;
import org.nanotek.beans.entity.LongIdName;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.nanotek.service.jpa.BasePersistenceService;

public abstract class LongIdNameEntityService <O extends LongIdName<O> , R extends <O>>
									extends BasePersistenceService<O, R>  {

	public LongIdNameEntityService(R rep) {
		super(rep);
	}

	@Transactional
	public abstract Iterable<O> findByNameContainingIgnoreCase(@NotNull String name);
}
