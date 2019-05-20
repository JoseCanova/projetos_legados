package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="work_alias")
public class WorkAlias implements Base<Long> {

	private Long id; 
	
	private Long work; 
	
	private Long name; 
	
	private String locale; 
	
	
	@Override
	public Long getId() {
		return id;
	}


	public Long getWork() {
		return work;
	}


	public void setWork(Long work) {
		this.work = work;
	}


	public Long getName() {
		return name;
	}


	public void setName(Long name) {
		this.name = name;
	}


	public String getLocale() {
		return locale;
	}


	public void setLocale(String locale) {
		this.locale = locale;
	}


	public void setId(Long id) {
		this.id = id;
	}

}
