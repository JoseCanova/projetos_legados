package org.nanotek.beans.csv;

import org.nanotek.Base;

public class MediumFormatBean implements Base<MediumFormatBean>{

	private static final long serialVersionUID = 6169777855661430422L;

	private Long id; 
	private String name; 
	private Long parent; 
	private Long childOrder; 
	private Integer year; 
	private String hasDiscIds; 
	private String description; 
	private String gid;
	
	public MediumFormatBean() {
	}

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

	@Override
	public MediumFormatBean get() {
		return Base.newInstance(MediumFormatBean.class).get();
	}

}
