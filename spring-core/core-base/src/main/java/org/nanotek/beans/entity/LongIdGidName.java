package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableGidEntity;

@MappedSuperclass
public abstract class LongIdGidName<K extends LongIdGidName<?,?,?>, G extends Serializable ,E extends Serializable> 
extends LongIdName<K> 
implements MutableGidEntity<G>{

	
	
	private static final long serialVersionUID = 6451845781007858778L;
	
	@NotNull
	@Column(name="gid", nullable=false , columnDefinition = "VARCHAR(50) NOT NULL")
	protected G gid;

	
	public LongIdGidName() {
		super();
	}

	public LongIdGidName(@NotNull String name) {
		super(name);
	}
	

	public LongIdGidName(
								@NotNull  G gid, 
								@NotBlank String name) {
		super(name);
		this.gid = gid;
	}


	public void setGid(G gid) {
		this.gid = gid;
	}

	@Override
	public G getGid() {
		return gid;
	}
	
}
