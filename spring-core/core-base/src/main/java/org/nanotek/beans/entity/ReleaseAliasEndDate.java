package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;

import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="re")
public class ReleaseAliasEndDate extends DatableBase {

	private static final long serialVersionUID = -2316725967469275402L;

	public ReleaseAliasEndDate() {
	}

	public ReleaseAliasEndDate(Integer year) {
		super(year);
	}

	public ReleaseAliasEndDate(Integer year, Integer month) {
		super(year, month);
	}

	public ReleaseAliasEndDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
