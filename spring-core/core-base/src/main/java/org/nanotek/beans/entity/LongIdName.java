package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableNameEntity;

@MappedSuperclass
public class LongIdName<K extends LongIdName<K>> extends SequenceLongBase<K> implements MutableNameEntity<String>{


	private static final long serialVersionUID = -5795977292694140863L;
	
	@NotNull
	@Column(name="name" , nullable=false, columnDefinition = "VARCHAR NOT NULL")
	public String name;
	
	public LongIdName() {
		super();
	}

	public LongIdName(@NotNull String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String k) {
		this.name = name;
	}

	
}
