package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.nanotek.Dimentionable;
import org.nanotek.Positionable;

@MappedSuperclass
public abstract class PositionEntityBase<K extends Serializable> extends SequenceLongBase implements Positionable<K>{

	private static final long serialVersionUID = 3659277405774297177L;

	public PositionEntityBase() {
	}
	
}
