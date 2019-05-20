package org.hubotek.model.cse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="cse_site")
public class CseSite implements Base<Long>{

	@Id
	private Long id; 
	
	@Column(length=30,insertable=true,updatable=false)
	private String location;

	public CseSite(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
