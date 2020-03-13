package org.nanotek.service;

import org.nanotek.beans.entity.LongIdGidNameEntity;
import org.nanotek.repository.jpa.LongIdGidNameEntityRepository;

public abstract class LongIdGidNameEntityService<O extends LongIdGidNameEntity , B extends LongIdGidNameEntityRepository<O>> extends LongIdNameEntityService<O, B> {

	public LongIdGidNameEntityService(B rep) {
		super(rep);
	}

}
