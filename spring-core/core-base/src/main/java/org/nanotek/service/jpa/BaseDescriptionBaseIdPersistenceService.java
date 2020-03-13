package org.nanotek.service.jpa;

import java.io.Serializable;

import org.nanotek.BaseDescriptionBase;
import org.nanotek.BaseDescriptionIdBase;
import org.nanotek.repository.jpa.BaseDescriptionBaseRepository;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.nanotek.service.EntityBasePersistenceService;

public abstract class BaseDescriptionBaseIdPersistenceService<O extends BaseDescriptionIdBase<ID,?> , 
				R extends BaseDescriptionBaseIdRepository<O,?, ID , ?> , 
				ID extends Serializable,BD extends BaseDescriptionBase<D> , D extends Serializable> 
				extends EntityBasePersistenceService<O, R, ID> {

	public BaseDescriptionBaseIdPersistenceService() {
		super();
	}

	public BaseDescriptionBaseIdPersistenceService(R baseRepository) {
		super(baseRepository);
	}

	
}
