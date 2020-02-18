package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nanotek.LongBase;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_alias")
public class ArtistAlias implements LongBase{

	@Id
	private Long id;
	@Column(name="artist_id",insertable=true)
	private Long artistId;
	@Column(name="name_key_id",insertable=true)
	private Long nameId;
	@Column(name="alias",insertable=true)
	private String alias;
	@Column(name="sortAlias",insertable=true)
	private String sortAlias;
	@Column(name="locale",insertable=true)
	private String locale;
	@Column(name="lastUpdated",insertable=true)
	private String lastUpdated;

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getSortAlias() {
		return sortAlias;
	}

	public void setSortAlias(String sortAlias) {
		this.sortAlias = sortAlias;
	}


}
