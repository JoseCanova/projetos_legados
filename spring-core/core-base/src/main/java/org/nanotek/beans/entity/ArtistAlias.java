package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.nanotek.MutableBase;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_alias")
public class ArtistAlias  extends LongIdSortNameEntity implements MutableBase<Long> {

	@NotNull
	@ManyToOne(optional = false)
	@JoinTable(
			  name = "artist_alias_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "artist_id",referencedColumnName = "id") )
	private Artist artist;

	@Column(name="locale",nullable=true , columnDefinition = "VARCHAR")
	private String locale;
	
	@ManyToOne(optional = false)
	@JoinTable(
			  name = "artist_alias_type_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "alias_id",referencedColumnName = "id") )
	private ArtistAliasType artistAliasType;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "artist_alias_begin_date_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private ArtistAliasBeginDate artistAliasBeginDate;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "artist_alias_end_date_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private ArtistAliasEndDate artistAliasEndDate;
	
	public ArtistAlias() {}
	
	public ArtistAlias(
			@NotNull Long id,
			@NotNull Artist artist, 
			@NotBlank @Size(min = 1, max = 1000) String name,
			@NotBlank @Size(min = 1, max = 1000) String sortName, 
			String locale, 
			ArtistAliasType artistAliasType,
			ArtistAliasBeginDate artistAliasBeginDate, 
			ArtistAliasEndDate artistAliasEndDate) {
		super(id , name , sortName);
		this.artist = artist;
		this.locale = locale;
		this.artistAliasType = artistAliasType;
		this.artistAliasBeginDate = artistAliasBeginDate;
		this.artistAliasEndDate = artistAliasEndDate;
	}

	public ArtistAlias(	@NotNull Long id, 
						@NotNull Artist artist, 
						@NotBlank @Size(min = 1, max = 1000) String name,
						@NotBlank @Size(min = 1, max = 1000) String sortName) {
		super(id , name , sortName);
		this.artist = artist;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public ArtistAliasType getArtistAliasType() {
		return artistAliasType;
	}

	public void setArtistAliasType(ArtistAliasType artistAliasType) {
		this.artistAliasType = artistAliasType;
	}

	public ArtistAliasBeginDate getArtistAliasBeginDate() {
		return artistAliasBeginDate;
	}

	public void setArtistAliasBeginDate(ArtistAliasBeginDate artistAliasBeginDate) {
		this.artistAliasBeginDate = artistAliasBeginDate;
	}

	public ArtistAliasEndDate getArtistAliasEndDate() {
		return artistAliasEndDate;
	}

	public void setArtistAliasEndDate(ArtistAliasEndDate artistAliasEndDate) {
		this.artistAliasEndDate = artistAliasEndDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sortName == null) ? 0 : sortName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistAlias other = (ArtistAlias) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sortName == null) {
			if (other.sortName != null)
				return false;
		} else if (!sortName.equals(other.sortName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistAlias [artist=" + artist + ", name=" + name + ", sortName=" + sortName + ", locale=" + locale
				+ ", artistAliasType=" + artistAliasType + ", artistAliasBeginDate=" + artistAliasBeginDate
				+ ", artistAliasEndDate=" + artistAliasEndDate + ", id=" + id + "]";
	}
	
}
