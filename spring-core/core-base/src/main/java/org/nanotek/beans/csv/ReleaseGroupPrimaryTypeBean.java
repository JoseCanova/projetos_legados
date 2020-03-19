package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.ReleaseGroupPrimaryType;

public class ReleaseGroupPrimaryTypeBean extends Result<ReleaseGroupPrimaryTypeBean,ReleaseGroupPrimaryType> {

	private static final long serialVersionUID = -4792229013963888593L;

	private Long ReleaseGroupPrimaryTypeId; 
	private String name; 
	private Long parent; 
	private Integer childOrder; 
	private String description; 
	private String gid;
	
	public ReleaseGroupPrimaryTypeBean() {
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

	public Long getReleaseGroupPrimaryTypeId() {
		return ReleaseGroupPrimaryTypeId;
	}

	public void setReleaseGroupPrimaryTypeId(Long releaseGroupPrimaryTypeId) {
		ReleaseGroupPrimaryTypeId = releaseGroupPrimaryTypeId;
	}

}
