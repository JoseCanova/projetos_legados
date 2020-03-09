package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@DiscriminatorValue(value="ArtistAliasType")
public class ArtistAliasType extends BaseType{

	private static final long serialVersionUID = 430998067473248669L;

	public ArtistAliasType() {
	}

	
	public ArtistAliasType(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}


	public ArtistAliasType(@NotBlank String name) {
		super(name);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "ArtistAliasType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}	
}
