package org.nanotek.beans;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class SuperLongBase implements LongBase {

	@Id
	private Long id;
	
	public SuperLongBase() {
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

}
