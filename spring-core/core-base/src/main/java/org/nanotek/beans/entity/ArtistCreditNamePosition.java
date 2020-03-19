package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableArtistCreditNameEntity;

@Entity
@DiscriminatorValue(value ="ArtistCreditNamePosition" )
public class ArtistCreditNamePosition<T extends ArtistCreditNamePosition<?>> extends LongPositionBase<ArtistCreditNamePosition> implements MutableArtistCreditNameEntity<ArtistCreditName<?>>{

	private static final long serialVersionUID = -482152069144029668L;
	
	@NotNull
	@OneToOne(mappedBy="position")
	public ArtistCreditName<?> artistCreditName;
	
	public ArtistCreditNamePosition(@NotNull ArtistCreditName<?> artistCreditName) {
		super();
		this.artistCreditName = artistCreditName;
	}


	public ArtistCreditName<?> getArtistCreditName() {
		return artistCreditName;
	}


	public void setArtistCreditName(ArtistCreditName<?> artistCretditName) {
		this.artistCreditName = artistCretditName;
	}
	

}
