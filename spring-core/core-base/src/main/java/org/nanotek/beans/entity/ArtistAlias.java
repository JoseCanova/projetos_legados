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
import org.nanotek.NameBase;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_alias")
public class ArtistAlias  extends EntityLongBase implements MutableBase<Long> , NameBase {

	@NotNull
	@ManyToOne(optional = false)
	@JoinTable(
			  name = "artist_alias_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "artist_id",referencedColumnName = "id") )
	private Artist artist;

	@NotBlank
	@Size(min = 1 , max = 1000)
	@Column(name="name",length=1000,nullable=false)
	private String name;
	
	@NotBlank
	@Size(min = 1 , max = 1000)
	@Column(name="sort_name",length=1000,nullable=false)
	private String sortName;
	
	@Column(name="locale",length=1000,nullable=true)
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
			  name = "artist_alias_begin_date_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private ArtistAliasEndDate artistAliasEndDate;
	
	
	public ArtistAlias() {}
	
	
	public ArtistAlias(@NotNull Artist artist, @NotBlank @Size(min = 1, max = 1000) String name,
			@NotBlank @Size(min = 1, max = 1000) String sortName, String locale, ArtistAliasType artistAliasType,
			ArtistAliasBeginDate artistAliasBeginDate, ArtistAliasEndDate artistAliasEndDate) {
		super();
		this.artist = artist;
		this.name = name;
		this.sortName = sortName;
		this.locale = locale;
		this.artistAliasType = artistAliasType;
		this.artistAliasBeginDate = artistAliasBeginDate;
		this.artistAliasEndDate = artistAliasEndDate;
	}

	public ArtistAlias(@NotNull Long id, @NotNull Artist artist, @NotBlank @Size(min = 1, max = 1000) String name,
			@NotBlank @Size(min = 1, max = 1000) String sortName) {
		super(id);
		this.artist = artist;
		this.name = name;
		this.sortName = sortName;
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

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
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

	
	
	
}
