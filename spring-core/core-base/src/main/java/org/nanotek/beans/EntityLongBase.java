package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.nanotek.LongBase;

@SuppressWarnings("serial")
@Entity
public class EntityLongBase implements LongBase {

	@Id
	protected Long id;
	
	/*
	 * @Override public void setId(Long id) { this.id = id; }
	 */

	@Override
	public Long getId() {
		return id;
	}

}

