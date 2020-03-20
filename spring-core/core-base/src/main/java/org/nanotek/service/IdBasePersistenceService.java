package org.nanotek.service;

import org.nanotek.Base;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.nanotek.service.jpa.BasePersistenceService;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class IdBasePersistenceService <O extends Base<O>, R extends IdBaseRepository<R,O>> 
extends BasePersistenceService<O,R>{
	
	public IdBasePersistenceService(@Autowired R baseRepository) {
		super(baseRepository);
	}

}
