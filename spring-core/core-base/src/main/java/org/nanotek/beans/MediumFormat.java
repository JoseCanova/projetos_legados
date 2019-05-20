package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="medium_format")
public class MediumFormat implements Base<String>{

	private String id; 
	private String name; 
	private String year; 
	
	@Override
	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public void setId(String id) {
		this.id = id;
	}



}
