package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="release_name")
public class ReleaseName implements Base<Long> {

	private Long id; 
	private String name; 
	private String refCount;
	
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
	
	public String getRefCount() {
		return refCount;
	}
	
	public void setRefCount(String refCount) {
		this.refCount = refCount;
	} 

}
