package org.nanotek.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_alias")
public class ArtistAlias implements Base<Long> {

	/* 
	 * id                  SERIAL,
    artist              INTEGER NOT NULL, -- references artist.id
    name                VARCHAR NOT NULL,
    locale              TEXT,
    edits_pending       INTEGER NOT NULL DEFAULT 0 CHECK (edits_pending >= 0),
    last_updated        TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    type                INTEGER, -- references artist_alias_type.id
    sort_name           VARCHAR NOT NULL,
    begin_date_year     SMALLINT,
    begin_date_month    SMALLINT,
    begin_date_day      SMALLINT,
    end_date_year       SMALLINT,
    end_date_month      SMALLINT,
    end_date_day        SMALLINT,
    primary_for_locale  BOOLEAN NOT NULL DEFAULT false,
    ended               BOOLEAN NOT NULL DEFAULT FALSE

	 */
	
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
