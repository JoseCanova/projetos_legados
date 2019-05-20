package org.hubotek.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.nanotek.Base;

@SuppressWarnings("serial")
@MappedSuperclass
public class Project implements Base<Long>{

	@Id
	private Long id;

	@Column(name="name" , length=255 , insertable=true , updatable=true , nullable=false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
