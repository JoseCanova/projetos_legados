package org.hubotek.model.cse;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.nanotek.Base;

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class CseBase implements Base<String>{

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
