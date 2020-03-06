package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ab")
public class ArtistBeginDate extends DatableBase{

	private static final long serialVersionUID = 4339317283945952774L;

	public ArtistBeginDate() {
	}

	public ArtistBeginDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}

	public ArtistBeginDate(Integer year, Integer month) {
		super(year, month);
	}

	public ArtistBeginDate(Integer year) {
		super(year);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
