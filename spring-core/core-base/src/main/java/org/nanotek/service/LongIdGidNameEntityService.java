package org.nanotek.service;

import org.nanotek.beans.entity.LongIdGidName;
import org.nanotek.repository.jpa.LongIdGidNameEntityRepository;

public abstract class LongIdGidNameEntityService<O extends LongIdGidName<O,String,String> , 
B extends LongIdGidNameEntityRepository<O>> 
extends LongIdNameEntityService<O, B> {

	public LongIdGidNameEntityService(B rep) {
		super(rep);
	}

}
