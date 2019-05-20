package org.nanotek.service.impl;

import org.nanotek.Base;

public class LongBase implements Base<Long> {

	Long id; 
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
