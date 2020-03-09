package org.nanotek.beans.entity;

import javax.persistence.MappedSuperclass;

import org.nanotek.Countable;

@MappedSuperclass
public abstract class CountBase<T> extends SequenceLongBase implements Countable<T>{

	private static final long serialVersionUID = 2967357630734834800L;

	public CountBase() {
	}

}
