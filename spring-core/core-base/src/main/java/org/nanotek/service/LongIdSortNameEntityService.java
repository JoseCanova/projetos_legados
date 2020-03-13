package org.nanotek.service;

import org.nanotek.beans.entity.LongIdSortNameEntity;
import org.nanotek.repository.jpa.LongIdSortNameEntityRepository;

public abstract class LongIdSortNameEntityService<O extends LongIdSortNameEntity , R extends LongIdSortNameEntityRepository<O>> extends LongIdNameEntityService<O, R> {

	public LongIdSortNameEntityService(R rep) {
		super(rep);
	}
	
}
