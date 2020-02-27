package org.nanotek.beans.csv;

import org.nanotek.LongBase;

public class InstrumentTypeBean implements LongBase{

	private static final long serialVersionUID = 245355432039730928L;

	private Long id; 
	
	private String name; 
	
	private Long parent; 
	
	private Integer childOrder; 
	
	private String description; 
	
	private String gid; 
	
	
	public InstrumentTypeBean() {
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


	public Integer getChildOrder() {
		return childOrder;
	}


	public void setChildOrder(Integer childOrder) {
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

}
