package org.nanotek.beans.csv;

import org.nanotek.ImmutableBase;
import org.nanotek.beans.entity.AreaType;
import org.nanotek.opencsv.ImmutableHolderBaseMap; 

public class AreaTypeBean<K extends AreaTypeBean<K,ID> , ID extends AreaType<?>> 
extends ImmutableHolderBaseMap<K,ID> 
implements  ImmutableBase<K,ID> {

	private static final long serialVersionUID = -6271568961378072618L;
	
	public Long areaTypeId; 
	public String name; 
	public Long parent; 
	public Long childOrder; 
	public String description; 
	public String gid;
	
	public AreaTypeBean() {
	}
	
	public AreaTypeBean(K immutable, ID id) {
		super(immutable, id);
	}

	public AreaTypeBean(K k) {
		super(k);
	}
	
	@Override
	public ID getId() {
		return id;
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


	public Long getAreaTypeId() {
		return areaTypeId;
	}


	public void setAreaTypeId(Long areaTypeId) {
		this.areaTypeId = areaTypeId;
	}

}
