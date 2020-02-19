package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;
import org.nanotek.ImmutableLongBase;

@Entity
@Table(name="artist_comment")
public class ArtistComment implements ImmutableLongBase {

	@Id
	@NotNull
	private Long id;
	
	@NotNull
	@Length(min = 0 , max = 1000)
	@Column(name="comment", length=1000, nullable = false , updatable = true )
	private String comment;
	
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

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}
	
}
