package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PositionEntityBase<K extends Serializable> extends SequenceLongBase<K>{

	private static final long serialVersionUID = 3659277405774297177L;

	public PositionEntityBase() {
	}
	
}
