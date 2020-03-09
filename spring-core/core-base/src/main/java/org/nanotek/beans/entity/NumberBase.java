package org.nanotek.beans.entity;

import javax.persistence.MappedSuperclass;

import org.nanotek.Numerable;

@MappedSuperclass
public abstract class NumberBase<T> extends SequenceLongBase implements Numerable<T> {
	
	private static final long serialVersionUID = 7977826134733440524L;

	public NumberBase() {
	}

}
