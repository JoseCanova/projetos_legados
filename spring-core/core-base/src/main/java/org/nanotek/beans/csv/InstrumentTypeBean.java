package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.InstrumentType;

public class InstrumentTypeBean extends Result<InstrumentTypeBean,InstrumentType>{

	private static final long serialVersionUID = 245355432039730928L;

	private Long instrumentTypeId; 
	
	private String name; 
	
	private Long parent; 
	
	private Long childOrder; 
	
	private String description; 
	
	private String gid; 
	
	
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
