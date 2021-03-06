package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("lb")
public class ArtistAliasBeginDate extends DatableBase{

	private static final long serialVersionUID = -9175061452241841539L;

	public ArtistAliasBeginDate() {
	}

	public ArtistAliasBeginDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}

	public ArtistAliasBeginDate(Integer year, Integer month) {
		super(year, month);
	}

	public ArtistAliasBeginDate(Integer year) {
		super(year);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "ArtistAliasBeginDate [id=" + id + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}

}
