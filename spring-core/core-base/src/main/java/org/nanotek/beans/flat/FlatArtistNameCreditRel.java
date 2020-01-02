package org.nanotek.beans.flat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity 
@IdClass(FlatArtistNameCreditRelId.class)
@Table(name="artist_credit_name_rel")
public class FlatArtistNameCreditRel {

	@Id 
	@Column(name="artist_name_id")
	private Long artistId;
	
	@Id 
	@Column(name="artist_credit_id")
	private Long artistCreditId;
	
	public FlatArtistNameCreditRel() {}

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
	
}

class FlatArtistNameCreditRelId {
    
	private Integer artistId;
    
	private Long artistCreditId;
    
	public Long getArtistCreditId() {
		return artistCreditId;
	}
	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}
	public Integer getArtistId() {
		return artistId;
	}
	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

}