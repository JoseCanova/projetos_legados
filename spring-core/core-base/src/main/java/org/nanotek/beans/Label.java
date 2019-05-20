package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="label")
public class Label implements Base<Long> {
	
	private Long id; 
	private String gid; 
	private Long name; 
	private Long sortName; 
	private String type; 
	private String labelCode; 
	private String country;
	private String beginDateYear; 
	private String beginDateMonth; 
	private String beginDateDay; 
	private String endDateYear; 
	private String endDateMonth; 
	private String endDateDay; 
	private String ipiCode;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public Long getName() {
		return name;
	}
	
	public void setName(Long name) {
		this.name = name;
	}
	
	public Long getSortName() {
		return sortName;
	}
	
	public void setSortName(Long sortName) {
		this.sortName = sortName;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLabelCode() {
		return labelCode;
	}
	
	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getBeginDateYear() {
		return beginDateYear;
	}
	
	public void setBeginDateYear(String beginDateYear) {
		this.beginDateYear = beginDateYear;
	}
	
	public String getBeginDateMonth() {
		return beginDateMonth;
	}
	
	public void setBeginDateMonth(String beginDateMonth) {
		this.beginDateMonth = beginDateMonth;
	}
	
	public String getBeginDateDay() {
		return beginDateDay;
	}
	
	public void setBeginDateDay(String beginDateDay) {
		this.beginDateDay = beginDateDay;
	}
	
	public String getIpiCode() {
		return ipiCode;
	}
	
	public void setIpiCode(String ipiCode) {
		this.ipiCode = ipiCode;
	}

	public String getEndDateYear() {
		return endDateYear;
	}

	public void setEndDateYear(String endDateYear) {
		this.endDateYear = endDateYear;
	}

	public String getEndDateMonth() {
		return endDateMonth;
	}

	public void setEndDateMonth(String endDateMonth) {
		this.endDateMonth = endDateMonth;
	}

	public String getEndDateDay() {
		return endDateDay;
	}

	public void setEndDateDay(String endDateDay) {
		this.endDateDay = endDateDay;
	} 

}
