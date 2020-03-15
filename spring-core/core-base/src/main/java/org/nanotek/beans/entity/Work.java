package org.nanotek.beans.entity;

import java.util.function.Consumer;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.LongBase;

@Entity
@Table(name="work")
public class Work implements LongBase {
	
	private Long id; 
	private String gid; 
	private String type; 
	private Long name; 
	private Long iswc; 
	
	
	@Override
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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Long getName() {
		return name;
	}


	public void setName(Long name) {
		this.name = name;
	}


	public Long getIswc() {
		return iswc;
	}


	public void setIswc(Long iswc) {
		this.iswc = iswc;
	}

}
