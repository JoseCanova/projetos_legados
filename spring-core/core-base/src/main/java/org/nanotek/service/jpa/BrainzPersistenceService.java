package org.nanotek.service.jpa;

import org.nanotek.beans.entity.BrainzBaseEntity;
import org.nanotek.repository.jpa.BrainzBaseRepository;

public class BrainzPersistenceService<B extends BrainzBaseEntity<B>> extends BasePersistenceService<B> {

	public BrainzPersistenceService() {}
	
	public BrainzPersistenceService(BrainzBaseRepository<B> b) {
		super(b);
	}
	
}
