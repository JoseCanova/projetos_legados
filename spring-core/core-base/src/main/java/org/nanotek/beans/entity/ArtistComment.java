package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.nanotek.MutableArtistEntity;
import org.nanotek.MutableCommentEntity;

@Entity
@DiscriminatorValue(value = "ArtistComment")
public class ArtistComment<E extends Serializable> extends CommentBase<String,ArtistComment<?>> implements MutableArtistEntity<Artist> , MutableCommentEntity<String>{

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

	
	
}
