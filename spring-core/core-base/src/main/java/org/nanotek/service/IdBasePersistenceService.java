package org.nanotek.service.jpa;

import java.io.Serializable;

import org.nanotek.IdBase;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.springframework.beans.factory.InitializingBean;

public abstract class IdBasePersistenceService <O extends IdBase<ID>, R extends IdBaseRepository<O,ID> , ID extends Serializable> implements InitializingBean{

	protected IdBaseRepository<O,ID> baseRepository;
	
	public IdBasePersistenceService() {
	}

	public IdBasePersistenceService(IdBaseRepository<O, ID> baseRepository) {
		super();
		this.baseRepository = baseRepository;
	}
	
}
