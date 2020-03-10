package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="artist_alias", 
uniqueConstraints= {
@UniqueConstraint(name="uk_artist_alias_id",columnNames={"artist_alias_id"})
},
indexes= {
			@Index(unique = false , name = "artist_alias_name_idx" , columnList ="name"),
			@Index(unique = false , name = "artist_alias_sort_name_idx" , columnList ="sort_name")
		})
public class ArtistAlias  extends LongIdSortNameEntity  {

	private static final long serialVersionUID = -6829974720983757034L;

	@NotNull
	@Column(name="artist_alias_id"  , nullable = false)
	private Long aliasId; 
	
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
			@NotBlank String name,
			@NotBlank String sortName, 
			String locale, 
			ArtistAliasType artistAliasType,
			ArtistAliasBeginDate artistAliasBeginDate, 
			ArtistAliasEndDate artistAliasEndDate) {
		super(name , sortName);
		this.aliasId = id;
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
		super(name , sortName);
		this.aliasId = id;
		this.artist = artist;
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

	public Long getAliasId() {
		return aliasId;
	}

	public void setAliasId(Long aliasId) {
		this.aliasId = aliasId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aliasId == null) ? 0 : aliasId.hashCode());
		result = prime * result + ((artistAliasType == null) ? 0 : artistAliasType.hashCode());
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
		if (aliasId == null) {
			if (other.aliasId != null)
				return false;
		} else if (!aliasId.equals(other.aliasId))
			return false;
		if (artistAliasType == null) {
			if (other.artistAliasType != null)
				return false;
		} else if (!artistAliasType.equals(other.artistAliasType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistAlias [aliasId=" + aliasId + ", artist=" + artist + ", locale=" + locale + ", artistAliasType="
				+ artistAliasType + ", artistAliasBeginDate=" + artistAliasBeginDate + ", artistAliasEndDate="
				+ artistAliasEndDate + ", sortName=" + sortName + ", name=" + name + ", id=" + id + "]";
	}

}
