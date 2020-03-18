package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;


@MappedSuperclass
public abstract class LongLengthyBase<K extends Serializable> extends LengthyBase<Long>{

	private static final long serialVersionUID = 4039937284168041782L;

	public LongLengthyBase() {
	}

	public LongLengthyBase(@NotNull Long length) {
		super();
		this.length = length;
	}

}
