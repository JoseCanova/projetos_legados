package org.nanotek.service;

import org.nanotek.beans.entity.LongIdSortName;
import org.nanotek.repository.jpa.LongIdSortNameEntityRepository;

public abstract class LongIdSortNameEntityService<O extends LongIdSortName , R extends LongIdSortNameEntityRepository<O>> extends LongIdNameEntityService<O, R> {

	public LongIdSortNameEntityService(R rep) {
		super(rep);
	}
	
}
