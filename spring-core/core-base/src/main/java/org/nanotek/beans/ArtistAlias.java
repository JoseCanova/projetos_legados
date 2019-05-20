package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_alias")
public class ArtistAlias implements Base<Long> {

	@Id
	private Long id; 
	@Column(name="artist_id",insertable=true)
	private Long artistId; 
	@Column(name="name_key_id",insertable=true)
	private Long nameId; 
	@Column(name="locale",insertable=true)
	private String locale;

	public ArtistAlias() {
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public Long getNameId() {
		return nameId;
	}

	public void setNameId(Long nameId) {
		this.nameId = nameId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
