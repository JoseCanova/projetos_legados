package org.nanotek.service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.nanotek.LongIdEntityNameBase;
import org.nanotek.repository.jpa.LongIdNameEntityRepository;
import org.nanotek.service.jpa.BasePersistenceService;

public abstract class LongIdNameEntityService <O extends LongIdEntityNameBase , B extends LongIdNameEntityRepository<O>> 
									extends BasePersistenceService<O, B>  {

	public LongIdNameEntityService(B rep) {
		super(rep);
	}

	@Transactional
	public Iterable<O> findByNameContainingIgnoreCase(@NotNull String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}
	
}
