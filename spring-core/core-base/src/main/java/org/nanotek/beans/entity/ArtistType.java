package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.nanotek.MutableArtistEntity;

@Entity
@DiscriminatorValue(value="ArtistType")
public class ArtistType<K extends Serializable> extends BaseType<Artist<?>> implements MutableArtistEntity<Artist<?>>{

	private static final long serialVersionUID = 962190613873549033L;
	
	@OneToOne(mappedBy = "artistType")
	public Artist<?> artist;

	public ArtistType() {
		super();
	}
	
	public ArtistType(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

	public ArtistType(@NotBlank String name) {
		super(name);
	}

	@Override
	public Artist<?> getArtist() {
		return artist;
	}

	@Override
	public void setArtist(Artist<?> e) {
		this.artist = e;
	}

}
