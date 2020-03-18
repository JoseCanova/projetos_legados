package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.nanotek.entities.BaseArtistAliasSortNameEntity;

@Entity
@DiscriminatorValue(value = "ArtistAliasSortName")
public class ArtistAliasSortName<K extends Serializable> extends SortNameBase<ArtistAliasSortName<?>> implements BaseArtistAliasSortNameEntity {

	private static final long serialVersionUID = -7162854301861535960L;

	@OneToOne(mappedBy="sortName")
	public ArtistAlias<?> artistAlias;
	
	public ArtistAliasSortName() {
	}

	public ArtistAliasSortName(@NotBlank String sortName) {
		super(sortName);
	}

	public ArtistAlias<?> getArtistAlias() {
		return artistAlias;
	}

	public void setArtistAlias(ArtistAlias<?> artistAlias) {
		this.artistAlias = artistAlias;
	}

}
