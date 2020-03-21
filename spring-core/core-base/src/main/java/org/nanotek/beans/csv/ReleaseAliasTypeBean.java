package org.nanotek.beans.csv;

import org.nanotek.ImmutableBase;
import org.nanotek.beans.entity.ReleaseAliasType;

public class ReleaseAliasTypeBean <K extends ReleaseAliasTypeBean<K,ID>,ID extends ReleaseAliasType<ID>>
implements ImmutableBase<K,ID>,BaseBean<K>{

	private static final long serialVersionUID = -6271568961378072618L;
	
	private ID id;
	
	public ID getId() { 
		return id; 
	}
	
	
	private Long resultAliasTypeId; 
	private String name; 
	private Long parent; 
	private Long childOrder; 
	private String description; 
	private String gid;
	
	
	public ReleaseAliasTypeBean(ID id) {
		super();
		this.id = id;
	}

	public ReleaseAliasTypeBean() {
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



	public Long getResultAliasTypeId() {
		return resultAliasTypeId;
	}



	public void setResultAliasTypeId(Long resultAliasTypeId) {
		this.resultAliasTypeId = resultAliasTypeId;
	}

}
