package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.MutableGidEntity;

@MappedSuperclass
public abstract class LongIdGidName<K extends Serializable> extends LongIdName<String> implements MutableGidEntity<K>{

	
	
	private static final long serialVersionUID = 6451845781007858778L;
	
	@NotNull
	@Column(name="gid", nullable=false , columnDefinition = "VARCHAR(50) NOT NULL")
	protected K gid;

	
	public LongIdGidName() {
		super();
	}

	public LongIdGidName(@NotNull String name) {
		super(name);
	}
	

	public LongIdGidName(
								@NotNull  K gid, 
								@NotBlank String name) {
		super(name);
		this.gid = gid;
	}


	public void setGid(K gid) {
		this.gid = gid;
	}

	@Override
	public K getGid() {
		return gid;
	}
	
}
