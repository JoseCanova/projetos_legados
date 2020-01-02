package org.nanotek.beans.flat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.nanotek.Base;

@Entity 
@IdClass(FlatArtistNameCreditRelId.class)
@Table(name="artist_credit_name_rel")
public class FlatArtistNameCreditRel implements Base<FlatArtistNameCreditRelId>{

	@Id 
	@Column(name="artist_name_id")
	private Long artistId;
	
	@Id 
	@Column(name="artist_credit_id")
	private Long artistCreditId;
	
	public FlatArtistNameCreditRel() {}

	public FlatArtistNameCreditRel(Long artistId2, Long artistCreditId2) {
		this.artistId = artistId2; 
		this.artistCreditId = artistCreditId2;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public Long getArtistCreditId() {
		return artistCreditId;
	}

	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}

	@Override
	public FlatArtistNameCreditRelId getId() {
		return new FlatArtistNameCreditRelId(this.artistId , this.artistCreditId);
	}

	@Override
	public void setId(FlatArtistNameCreditRelId id) {
		this.artistId = id.getArtistId();
		this.artistCreditId = id.getArtistCreditId();
	}
	
}

