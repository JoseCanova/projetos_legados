package org.nanotek.service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.nanotek.LongIdEntityBase;
import org.nanotek.repository.jpa.LongIdNameEntityRepository;
import org.nanotek.service.jpa.BasePersistenceService;

public abstract class LongIdNameEntityService <O extends LongIdEntityBase , B extends LongIdNameEntityRepository<O>> 
									extends BasePersistenceService<O, B>  {

	public LongIdNameEntityService(B rep) {
		super(rep);
	}

	@Transactional
	public Iterable<O> findByNameContainingIgnoreCase(@NotNull String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}
	
}
