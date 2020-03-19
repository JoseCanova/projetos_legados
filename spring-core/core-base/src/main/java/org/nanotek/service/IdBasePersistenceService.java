package org.nanotek.service;

import org.nanotek.IdBase;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.nanotek.service.jpa.BasePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;


//TODO: 1 = 1 after remove BasePersistenceService on refactor.
public abstract class IdBasePersistenceService <O extends IdBase<O,Long>, R extends IdBaseRepository<O>> 
extends BasePersistenceService<O, R>{
	
	public IdBasePersistenceService(@Autowired R baseRepository) {
		super(baseRepository);
	}

}
