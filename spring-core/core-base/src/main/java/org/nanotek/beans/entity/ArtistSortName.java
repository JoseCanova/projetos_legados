package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.nanotek.ArtistEntity;


@Entity
@DiscriminatorValue(value="ArtistSortName")
public class ArtistSortName extends SortNameBase implements ArtistEntity<Artist> {

	private static final long serialVersionUID = 492175239931176224L;

	@OneToOne(mappedBy = "sortName")
	private Artist artist;
	
	public ArtistSortName(@NotBlank String sortName) {
		super(sortName);
	}

	public ArtistSortName() {
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
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
		ArtistSortName other = (ArtistSortName) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistSortName [artist=" + artist + ", sortName=" + sortName + ", id=" + id + "]";
	}

}
