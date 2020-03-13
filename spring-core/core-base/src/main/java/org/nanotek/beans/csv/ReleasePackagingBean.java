package org.nanotek.beans.csv;

import org.nanotek.Base;

public class ReleasePackagingBean implements Base<ReleasePackagingBean>{

	private static final long serialVersionUID = -6068518463159348252L;
	/**
	 * 
	 * id                  SERIAL,
    name                VARCHAR(255) NOT NULL,
    parent              INTEGER, -- references release_packaging.id
    child_order         INTEGER NOT NULL DEFAULT 0,
    description         TEXT,
    gid                 uuid NOT NULL
	 */
	
	private Long id; 
	private String name; 
	private Long parent; 
	private Long childOrder; 
	private String description; 
	private String gid;
	
	public ReleasePackagingBean() {
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
	public ReleasePackagingBean get() {
		return Base.newInstance(ReleasePackagingBean.class).get();
	}

}
