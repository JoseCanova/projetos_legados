package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.Gender;

public class GenderBean extends Result<GenderBean,Gender>{

	private static final long serialVersionUID = -1492542566677551150L;
	private Long genderId; 
	private String name; 
	private Long parent; 
	private Long childOrder; 
	private String description; 
	private String gid;
	
	public GenderBean() {
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


	public Long getGenderId() {
		return genderId;
	}


	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

}
