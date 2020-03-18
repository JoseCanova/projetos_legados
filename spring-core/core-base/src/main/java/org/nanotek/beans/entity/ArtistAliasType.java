package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.nanotek.ArtistAlias;
import org.nanotek.MutableArtistAliasEntity;

@Entity
@DiscriminatorValue(value="ArtistAliasType")
public class ArtistAliasType<K extends Serializable> extends BaseType<ArtistAlias<?>> implements  
																		  MutableArtistAliasEntity<ArtistAlias<?>>  {

	private static final long serialVersionUID = 430998067473248669L;
	
	@OneToOne(mappedBy = "artistAliasType" , optional = false)
	public ArtistAlias<?> artistAlias;

	public ArtistAliasType() {
	}
	
	public ArtistAliasType(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

	public ArtistAliasType(@NotBlank String name) {
		super(name);
	}

	@Override
	public ArtistAlias<?> getArtistAlias() {
		return artistAlias;
	}

	@Override
	public void setArtistAlias(ArtistAlias<?> k) {
		this.artistAlias = k;
	}

}
