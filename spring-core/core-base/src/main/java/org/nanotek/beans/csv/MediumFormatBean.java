package org.nanotek.beans.csv;

import org.nanotek.ImmutableBase;
import org.nanotek.beans.entity.MediumFormat;

public class MediumFormatBean 
<K extends MediumFormatBean<K,ID>, ID extends MediumFormat<ID>>
implements ImmutableBase<K, ID>, BaseBean<K>{

	private static final long serialVersionUID = 6169777855661430422L;

	private ID id;
	
	public ID getId() { 
		return id;
	}
	
	public Long mediumFormatId;
	public String name; 
	public Long parent; 
	public Long childOrder; 
	public Integer year; 
	public String hasDiscIds; 
	public String description; 
	public String gid;
	
	
	
	public MediumFormatBean(ID id) {
		super();
		this.id = id;
	}

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
