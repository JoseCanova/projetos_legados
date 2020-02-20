package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.nanotek.LongBase;

@SuppressWarnings("serial")
@MappedSuperclass
public class SuperLongBase implements LongBase {

	@Id
	@NotNull
	@Column(name="id",nullable=false,unique=true)
	protected Long id;
	
	public SuperLongBase() {
	}

	@Override
	public Long getId() {
		return id;
	}

}
