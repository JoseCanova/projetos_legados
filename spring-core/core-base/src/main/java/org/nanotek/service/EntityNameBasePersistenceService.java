package org.nanotek.service;

import java.io.Serializable;

import org.nanotek.entities.MutableNameBase;
import org.nanotek.repository.jpa.EntityNameBaseRepository;
import org.nanotek.repository.jpa.IdBaseRepository;

public abstract class EntityNameBasePersistenceService<O extends MutableNameBase<ID,?>, R extends EntityNameBaseRepository<O,ID>,ID extends Serializable> extends IdBasePersistenceService<O, R, ID> {

	public EntityNameBasePersistenceService() {
		super();
	}

	public EntityNameBasePersistenceService(IdBaseRepository<O, ID> baseRepository) {
		super(baseRepository);
	}

}
