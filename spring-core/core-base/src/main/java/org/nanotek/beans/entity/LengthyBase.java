package org.nanotek.beans.entity;

import javax.persistence.MappedSuperclass;

import org.nanotek.Dimentionable;
import org.nanotek.LengthBase;

@MappedSuperclass
public abstract class LengthyBase<K extends Number> extends SequenceLongBase implements LengthBase<K> ,  Dimentionable{

	private static final long serialVersionUID = -8797268785342768025L;
	
	public LengthyBase() {
	}

}
