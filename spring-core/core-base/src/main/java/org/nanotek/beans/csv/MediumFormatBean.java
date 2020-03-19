package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.MediumFormat;

public class MediumFormatBean extends Result<MediumFormatBean,MediumFormat>{

	private static final long serialVersionUID = 6169777855661430422L;

	private Long mediumFormatId;
	private String name; 
	private Long parent; 
	private Long childOrder; 
	private Integer year; 
	private String hasDiscIds; 
	private String description; 
	private String gid;
	
	public MediumFormatBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Long getChildOrder() {
		return childOrder;
	}

	public void setChildOrder(Long childOrder) {
		this.childOrder = childOrder;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getHasDiscIds() {
		return hasDiscIds;
	}

	public void setHasDiscIds(String hasDiscIds) {
		this.hasDiscIds = hasDiscIds;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public Long getMediumFormatId() {
		return mediumFormatId;
	}

	public void setMediumFormatId(Long mediumFormatId) {
		this.mediumFormatId = mediumFormatId;
	}

}
