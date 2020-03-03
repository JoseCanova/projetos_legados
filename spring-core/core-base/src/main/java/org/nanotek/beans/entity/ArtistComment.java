package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.nanotek.ImmutableLongBase;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="artist_comment")
public class ArtistComment implements ImmutableLongBase {

	private static final long serialVersionUID = 4732596233741255252L;

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
	
}
