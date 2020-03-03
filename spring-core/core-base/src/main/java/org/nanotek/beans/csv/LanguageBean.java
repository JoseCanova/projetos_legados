package org.nanotek.beans.csv;

import org.nanotek.Base;

public class LanguageBean implements Base{

	private static final long serialVersionUID = 2997501833949969600L;

	private Long id; 
	private String isoCode2t; 
	private String isoCode2b; 
	private String isoCode1; 
	private String name; 
	private Long frequency;
	private String isoCode3;
	
	
	public LanguageBean() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIsoCode2t() {
		return isoCode2t;
	}


	public void setIsoCode2t(String isoCode2t) {
		this.isoCode2t = isoCode2t;
	}


	public String getIsoCode2b() {
		return isoCode2b;
	}


	public void setIsoCode2b(String isoCode2b) {
		this.isoCode2b = isoCode2b;
	}


	public String getIsoCode1() {
		return isoCode1;
	}


	public void setIsoCode1(String isoCode1) {
		this.isoCode1 = isoCode1;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getFrequency() {
		return frequency;
	}


	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}


	public String getIsoCode3() {
		return isoCode3;
	}


	public void setIsoCode3(String isoCode3) {
		this.isoCode3 = isoCode3;
	}


	@Override
	public String toString() {
		return "LanguageBean [id=" + id + ", isoCode2t=" + isoCode2t + ", isoCode2b=" + isoCode2b + ", isoCode1="
				+ isoCode1 + ", name=" + name + ", frequency=" + frequency + ", isoCode3=" + isoCode3 + "]";
	}

}
