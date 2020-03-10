package org.nanotek.beans.entity;

import javax.persistence.MappedSuperclass;

import org.nanotek.Dimentionable;
import org.nanotek.Positionable;

@MappedSuperclass
public abstract class PositionBase<K> extends SequenceLongBase implements Positionable<K> , Dimentionable{

	private static final long serialVersionUID = 3659277405774297177L;

	public PositionBase() {
	}

}
