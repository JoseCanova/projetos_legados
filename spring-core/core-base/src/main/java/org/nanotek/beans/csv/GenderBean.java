package org.nanotek.beans.csv;

import org.nanotek.ImmutableBase;
import org.nanotek.beans.entity.Gender;

public class GenderBean
<K extends GenderBean<K,ID>, ID extends Gender<ID>> 
implements ImmutableBase<K,ID>{

	
	private ID id;
	
	public ID getId() {
		return id;
	}
	
	public static final long serialVersionUID = -1492542566677551150L;
	public Long genderId; 
	public String name; 
	public Long parent; 
	public Long childOrder; 
	public String description; 
	public String gid;
	
	
	public GenderBean(ID id) {
		super();
		this.id = id;
	}


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
