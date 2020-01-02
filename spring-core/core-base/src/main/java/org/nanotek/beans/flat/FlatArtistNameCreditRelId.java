package org.nanotek.beans.flat;

import java.io.Serializable;

public class FlatArtistNameCreditRelId implements Serializable{
    
	private Long artistId;
    
	private Long artistCreditId;
	
	public FlatArtistNameCreditRelId() {}
    
	public FlatArtistNameCreditRelId(Long artistId , Long artistCreditId) { 
		this.artistId = artistId; 
		this.artistCreditId = artistCreditId;
	}
	
	public Long getArtistCreditId() {
		return artistCreditId;
	}
	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}
	public Long getArtistId() {
		return artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

}