package org.nanotek.beans.entity;

import javax.persistence.MappedSuperclass;

import org.nanotek.Dimentionable;

@MappedSuperclass
public abstract class LengthyBase<K> extends SequenceLongBase implements Dimentionable{

	public LengthyBase() {
	}

}
