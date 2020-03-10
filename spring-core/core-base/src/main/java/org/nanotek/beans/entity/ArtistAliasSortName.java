package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
@DiscriminatorValue(value = "ArtistAliasSortName")
public class ArtistAliasSortName extends SortNameBase{

	private static final long serialVersionUID = -7162854301861535960L;

	@OneToOne(mappedBy="sortName")
	private ArtistAlias artistAlias;
	
	public ArtistAliasSortName() {
	}

	public ArtistAliasSortName(@NotBlank String sortName) {
		super(sortName);
	}

	public ArtistAlias getArtistAlias() {
		return artistAlias;
	}

	public void setArtistAlias(ArtistAlias artistAlias) {
		this.artistAlias = artistAlias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artistAlias == null) ? 0 : artistAlias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistAliasSortName other = (ArtistAliasSortName) obj;
		if (artistAlias == null) {
			if (other.artistAlias != null)
				return false;
		} else if (!artistAlias.equals(other.artistAlias))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistAliasSortName [artistAlias=" + artistAlias + ", sortName=" + sortName + ", id=" + id + "]";
	}
	
}
