package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableArtistCreditNameEntity;

public class ArtistCreditNameJoinPhrase<K extends Serializable> 
																	extends JoinPhraseBase<K> 
																	implements MutableArtistCreditNameEntity<ArtistCreditName<?>> {

	private static final long serialVersionUID = 5258524420279200258L;
	
	public ArtistCreditName<?> artistCreditName;

	public ArtistCreditNameJoinPhrase() {
		super();
	}

	public ArtistCreditNameJoinPhrase(@NotNull K joinPhrase) {
		super(joinPhrase);
	}

	public ArtistCreditName<?> getArtistCreditName() {
		return artistCreditName;
	}

	public void setArtistCreditName(ArtistCreditName<?> artistCreditName) {
		this.artistCreditName = artistCreditName;
	}
	
}
