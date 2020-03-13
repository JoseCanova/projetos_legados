package org.nanotek.service;

import java.io.Serializable;

import org.nanotek.EntityBase;
import org.nanotek.repository.jpa.EntityBaseRepository;
import org.nanotek.repository.jpa.IdBaseRepository;

public abstract class EntityBasePersistenceService<O extends EntityBase<ID> , R extends EntityBaseRepository<O, ID>, ID extends Serializable > extends IdBasePersistenceService<O, R, ID> {

	public EntityBasePersistenceService() {
		super();
	}

	public EntityBasePersistenceService(IdBaseRepository<O, ID> baseRepository) {
		super(baseRepository);
	}

}
