package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.nanotek.collections.StreamableArtistEntity;

@Entity
@DiscriminatorValue(value="ArtistType")
public class ArtistType<K extends Serializable> extends BaseType<Artist<?>> {

	private static final long serialVersionUID = 962190613873549033L;
	
	@OneToMany(mappedBy = "artistType",orphanRemoval = false,fetch = FetchType.LAZY)
	public StreamableArtistEntity<Artist<?>> artists;

	public ArtistType() {
		super();
	}
	
	public ArtistType(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

	public ArtistType(@NotBlank String name) {
		super(name);
	}


}
