package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ArtistAliasEndDate")
public class ArtistAliasEndDate extends DatableBase{

	private static final long serialVersionUID = 7987268027913627678L;

	public ArtistAliasEndDate() {
	}

	public ArtistAliasEndDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}

	public ArtistAliasEndDate(Integer year, Integer month) {
		super(year, month);
	}

	public ArtistAliasEndDate(Integer year) {
		super(year);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "ArtistAliasEndDate [id=" + id + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	
	
}
