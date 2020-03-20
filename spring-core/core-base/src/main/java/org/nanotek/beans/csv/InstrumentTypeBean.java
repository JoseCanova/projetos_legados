package org.nanotek.beans.csv;

import org.nanotek.ImmutableBase;
import org.nanotek.beans.entity.InstrumentType;

public class InstrumentTypeBean 
<K extends InstrumentTypeBean<K,ID> ,ID extends InstrumentType<ID>>
implements ImmutableBase<K, ID>{
	

	private static final long serialVersionUID = 245355432039730928L;

	private ID id;
	
	public ID getId() { 
		return id;
	}
	
	public Long instrumentTypeId; 
	
	public String name; 
	
	public Long parent; 
	
	public Long childOrder; 
	
	public String description; 
	
	public String gid; 
	
	
	
	public InstrumentTypeBean(ID id) {
		super();
		this.id = id;
	}



	public InstrumentTypeBean() {
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


	public Long getInstrumentTypeId() {
		return instrumentTypeId;
	}

	public void setInstrumentTypeId(Long instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}

}
