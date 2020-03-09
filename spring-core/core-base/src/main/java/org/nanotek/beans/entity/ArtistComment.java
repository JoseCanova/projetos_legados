package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="artist_comment")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ArtistComment extends CommentBase {

	private static final long serialVersionUID = 2608408556126104972L;

	@OneToOne(mappedBy = "artistComment")
	private Artist artist;

	public ArtistComment() {}
	
	public ArtistComment(@NotBlank String comment, Artist artist) {
		super(comment);
	}
	
	public ArtistComment(@NotBlank String comment) {
		super(comment);
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
		ArtistComment other = (ArtistComment) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistComment [artist=" + artist + ", comment=" + comment + ", id=" + id + "]";
	}
	
}
