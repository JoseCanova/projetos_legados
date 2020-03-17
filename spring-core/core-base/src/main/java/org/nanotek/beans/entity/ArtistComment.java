package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.nanotek.IdBase;

@Entity
@DiscriminatorValue(value = "ArtistComment")
public class ArtistComment extends CommentBase<String> implements IdBase<CommentBase<String>,Long>{

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
	public String toString() {
		return "ArtistComment [artist=" + artist + ", comment=" + comment + ", id=" + id + "]";
	}

	@Override
	public void setComment(String k) {
		this.comment = k;
	}

	@Override
	public String getComment() {
		return comment;
	}

	
	
}
