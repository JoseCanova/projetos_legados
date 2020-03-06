package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ae")
public class ArtistEndDate extends DatableBase{

	private static final long serialVersionUID = 5843448446493083180L;

	public ArtistEndDate() {
	}

	public ArtistEndDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}

	public ArtistEndDate(Integer year, Integer month) {
		super(year, month);
	}

	public ArtistEndDate(Integer year) {
		super(year);
	}
	
}
