package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.nanotek.MutableLenght;

@MappedSuperclass
public abstract class LengthyBase<K extends Serializable> extends SequenceLongBase implements MutableLenght<K>{

	@NotNull
	@Column(name="length" , nullable=false)
	protected  K length;
	
	public LengthyBase() {
	}

	@Override
	public void setLength(K length) {
		this.length = length;
	}
	
}
