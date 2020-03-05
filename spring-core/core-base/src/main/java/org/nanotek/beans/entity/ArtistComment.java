package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.nanotek.ImmutableLongBase;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="artist_comment")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ArtistComment implements ImmutableLongBase {

	private static final long serialVersionUID = 2608408556126104972L;

	@Id
	@NotNull
	private Long id;
	
	@NotNull
	@Length(min = 0 , max = 1000)
	@Column(name="comment", length=1000, nullable = false , updatable = true )
	private String comment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Artist artist;

	public ArtistComment() {}
	
	public ArtistComment(String comment, Artist artist) {
		super();
		this.comment = comment;
		this.artist = artist;
		this.id = artist.getId();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@JsonIgnore
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistComment other = (ArtistComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
