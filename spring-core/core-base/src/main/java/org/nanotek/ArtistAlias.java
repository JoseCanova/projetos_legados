package org.nanotek;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistAliasBeginDate;
import org.nanotek.beans.entity.ArtistAliasEndDate;
import org.nanotek.beans.entity.ArtistAliasLocale;
import org.nanotek.beans.entity.ArtistAliasSortName;
import org.nanotek.beans.entity.ArtistAliasType;
import org.nanotek.beans.entity.LongIdName;
import org.nanotek.beans.entity.MutableAliasIdEntity;

@Entity
@Table(name="artist_alias", 
uniqueConstraints= {
@UniqueConstraint(name="uk_artist_alias_id",columnNames={"artist_alias_id"})
})
public class ArtistAlias<K extends Serializable>  extends LongIdName<String>  implements 
														BaseEntity,
														MutableAliasIdEntity<Long>,
														MutableArtistAliasSortNameEntity<ArtistAliasSortName<?>>,
														MutableArtistEntity<Artist<?>> , 
														MutableArtistAliasTypeEntity<ArtistAliasType<?>> , 
														MutableArtistAliasLocaleEntity<ArtistAliasLocale>,
														MutableArtistAliasBeginDateEntity<ArtistAliasBeginDate>,
														MutableArtistAliasEndDateEntity<ArtistAliasEndDate>{

	private static final long serialVersionUID = -6829974720983757034L;

	@NotNull
	@Column(name="artist_alias_id"  , nullable = false)
	public Long aliasId; 
	
	@NotNull
	@OneToOne(optional = false)
	@JoinTable(
			  name = "artist_alias_sortname_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "sort_name_id",referencedColumnName = "id") )
	public ArtistAliasSortName<?> artistAliasSortName;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinTable(
			  name = "artist_alias_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "artist_id",referencedColumnName = "id") )
	public Artist<?> artist;

	@OneToOne(optional = true)
	@JoinTable(
			  name = "artist_alias_locale_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "locale_id",referencedColumnName = "id") )
	public ArtistAliasLocale artistAliasLocale;
	
	@ManyToOne(optional = false)
	@JoinTable(
			  name = "artist_alias_type_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "alias_type_id",referencedColumnName = "id") )
	public ArtistAliasType<?> artistAliasType;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "artist_alias_begin_date_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	public ArtistAliasBeginDate artistAliasBeginDate;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinTable(
			  name = "artist_alias_end_date_join", 
			  joinColumns = @JoinColumn(name = "artist_alias_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	public ArtistAliasEndDate artistAliasEndDate;
	
	public ArtistAlias() {}
	
	public ArtistAlias(
			@NotNull Long id,
			@NotNull Artist<?> artist, 
			@NotBlank String name,
			@NotNull ArtistAliasSortName<?> sortName, 
			ArtistAliasLocale locale, 
			ArtistAliasType<?> artistAliasType,
			ArtistAliasBeginDate artistAliasBeginDate, 
			ArtistAliasEndDate artistAliasEndDate) {
		super(name);
		this.aliasId = id;
		this.artist = artist;
		this.artistAliasLocale = locale;
		this.artistAliasType = artistAliasType;
		this.artistAliasBeginDate = artistAliasBeginDate;
		this.artistAliasEndDate = artistAliasEndDate;
		this.artistAliasSortName = sortName;
	}

	public ArtistAlias(	@NotNull Long id, 
			@NotNull Artist<?> artist, 
			@NotBlank String name) {
				super(name);
				this.aliasId = id;
				this.artist = artist;
	}
	
	public ArtistAlias(	@NotNull Long id, 
						@NotNull Artist<?> artist, 
						@NotBlank String name,
						@NotNull ArtistAliasSortName<?> sortName) {
		super(name);
		this.aliasId = id;
		this.artist = artist;
		this.artistAliasSortName = sortName;
	}


}
