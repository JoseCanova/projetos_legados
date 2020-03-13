package org.nanotek.service.jpa;

import java.io.Serializable;

import org.nanotek.BaseDescriptionBase;
import org.nanotek.repository.jpa.BaseDescriptionBaseRepository;
import org.nanotek.repository.jpa.IdBaseRepository;

public abstract class BaseDescriptionBasePersistenceService<O extends BaseDescriptionBase<ID,?> , R extends BaseDescriptionBaseRepository<O,ID> , ID extends Serializable> extends EntityBasePersistenceService<O, R, ID> {

	public BaseDescriptionBasePersistenceService() {
		super();
	}

	public BaseDescriptionBasePersistenceService(IdBaseRepository<O, ID> baseRepository) {
		super(baseRepository);
	}

	
}
