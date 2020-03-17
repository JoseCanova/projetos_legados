package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.nanotek.BaseEntity;

@Entity
@DiscriminatorValue("ArtistAliasBeginDate")
public class ArtistAliasBeginDate extends DatableBase<Integer,Integer,Integer> 
								  implements BaseEntity{

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
	
}
