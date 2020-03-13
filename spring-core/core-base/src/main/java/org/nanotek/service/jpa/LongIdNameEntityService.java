package org.nanotek.service.jpa;

import javax.validation.constraints.NotNull;

import org.nanotek.LongIdEntityNameBase;
import org.nanotek.repository.jpa.LongIdNameEntityRepository;
import org.springframework.beans.factory.InitializingBean;

public abstract class LongIdNameEntityService <O extends LongIdEntityNameBase , B extends LongIdNameEntityRepository<O>> 
									extends BasePersistenceService<O, B>  {

	public LongIdNameEntityService(B rep) {
		super(rep);
	}

	public Iterable<O> findByNameContainingIgnoreCase(@NotNull String name) {
		return baseRepository.findByNameContainingIgnoreCase(name);
	}
	
}
