package org.nanotek.beans.csv;

import org.nanotek.LongBase;

public class InstrumentBean implements LongBase{

	private static final long serialVersionUID = -6916258778573566572L;
	
	private Long id; 
	private String gid; 
	private String name; 
	private Long type; 
	private Integer editsPending; 
	private String lastUpdatead; 
	private String comment; 
	private String description;
	
	public InstrumentBean() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Integer getEditsPending() {
		return editsPending;
	}

	public void setEditsPending(Integer editsPending) {
		this.editsPending = editsPending;
	}

	public String getLastUpdatead() {
		return lastUpdatead;
	}

	public void setLastUpdatead(String lastUpdatead) {
		this.lastUpdatead = lastUpdatead;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "InstrumentBean [id=" + id + ", gid=" + gid + ", name=" + name + ", type=" + type + ", editsPending="
				+ editsPending + ", lastUpdatead=" + lastUpdatead + ", comment=" + comment + ", description="
				+ description + "]";
	}
	

}
