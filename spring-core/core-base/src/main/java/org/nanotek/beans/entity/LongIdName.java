package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class LongIdName<K extends Serializable> extends SequenceLongBase<K> implements MutableNameEntity<K>{


	private static final long serialVersionUID = -5795977292694140863L;
	
	@NotNull
	@Column(name="name" , nullable=false, columnDefinition = "VARCHAR NOT NULL")
	public K name;
	
	public LongIdName() {
		super();
	}

	public LongIdName(@NotNull K name) {
		super();
		this.name = name;
	}

	public void setName(K name) { 
		this.name = name;
	}
	
	@Override
	public K getName() {
		return name;
	}
	
}
