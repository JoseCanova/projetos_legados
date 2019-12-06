package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.StringBase;

@SuppressWarnings("serial")
@Entity
@Table(name="medium_format")
public class MediumFormat extends StringBase{

	@Column(name = "NAME")
	private String name; 
	@Column(name = "YEAR")
	private String year; 
	
	public MediumFormat() { 
		super();
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

}

