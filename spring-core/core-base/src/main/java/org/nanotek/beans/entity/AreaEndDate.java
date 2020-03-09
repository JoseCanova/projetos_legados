package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ee")
public class AreaEndDate extends DatableBase {

	private static final long serialVersionUID = -8963127006492095677L;

	public AreaEndDate() {
	}

	public AreaEndDate(Integer year) {
		super(year);
	}

	public AreaEndDate(Integer year, Integer month) {
		super(year, month);
	}

	public AreaEndDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}

}
