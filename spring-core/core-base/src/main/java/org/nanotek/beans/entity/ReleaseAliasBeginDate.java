package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "rb")
public class ReleaseAliasBeginDate extends DatableBase {

	private static final long serialVersionUID = -3004596106076682952L;
	
	public ReleaseAliasBeginDate() {
	}

	public ReleaseAliasBeginDate(Integer year) {
		super(year);
	}

	public ReleaseAliasBeginDate(Integer year, Integer month) {
		super(year, month);
	}

	public ReleaseAliasBeginDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
