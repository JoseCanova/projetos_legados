package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="language")
public class Language implements Base<Long> {

	private Long id; 
	private String isoCode3t; 
	private String isoCode3d; 
	private String isCode2; 
	private String name; 
	private String frequency;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIsoCode3t() {
		return isoCode3t;
	}
	
	public void setIsoCode3t(String isoCode3t) {
		this.isoCode3t = isoCode3t;
	}
	
	public String getIsoCode3d() {
		return isoCode3d;
	}
	
	public void setIsoCode3d(String isoCode3d) {
		this.isoCode3d = isoCode3d;
	}
	
	public String getIsCode2() {
		return isCode2;
	}
	
	public void setIsCode2(String isCode2) {
		this.isCode2 = isCode2;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	} 

}
