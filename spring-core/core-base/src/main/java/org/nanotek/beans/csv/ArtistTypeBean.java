package org.nanotek.beans.csv;

import org.nanotek.Base;

public class ArtistTypeBean implements Base<ArtistTypeBean> {

	private static final long serialVersionUID = -6271568961378072618L;
	
	private Long id; 
	private String name; 
	private Long parent; 
	private Long childOrder; 
	private String description; 
	private String gid;
	
	public ArtistTypeBean() {
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
	public ArtistTypeBean get() {
		return Base.newInstance(ArtistTypeBean.class).get();
	}
}
