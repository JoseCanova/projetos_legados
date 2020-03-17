package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value ="ArtistCreditNamePosition" )
public class ArtistCreditNamePosition<T extends Serializable> extends LongPositionBase{

	private static final long serialVersionUID = -482152069144029668L;
	
	@NotNull
	@OneToOne(mappedBy="position")
	public ArtistCreditName<?> artistCretditName;
	
	

	public ArtistCreditNamePosition(@NotNull ArtistCreditName<?> artistCretditName) {
		super();
		this.artistCretditName = artistCretditName;
	}
	
	

}
