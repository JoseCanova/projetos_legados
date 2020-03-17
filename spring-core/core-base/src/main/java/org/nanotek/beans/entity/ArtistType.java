package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@DiscriminatorValue(value="ArtistType")
public class ArtistType extends BaseType {

	private static final long serialVersionUID = 962190613873549033L;

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
