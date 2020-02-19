package org.nanotek.beans;

import javax.persistence.Entity;

import org.nanotek.LongBase;

@SuppressWarnings("serial")
@Entity
public class EntityLongBase implements LongBase {

	protected Long id;
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

}

