package org.nanotek.beans.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.BaseEntity;
import org.nanotek.Kong;
import org.nanotek.MutableAreaEntity;
import org.nanotek.MutableArtistBeginDateEntity;
import org.nanotek.MutableArtistCommentEntity;
import org.nanotek.MutableArtistCreditEntity;
import org.nanotek.MutableArtistEndDateEntity;
import org.nanotek.MutableArtistIdEntity;
import org.nanotek.MutableArtistSortNameEntity;
import org.nanotek.MutableArtistTypeEntity;
import org.nanotek.collections.AritistCreditStreamableEntity;
import org.nanotek.collections.StreamableEntity;

@Entity
@Table(name="artist" , 
		uniqueConstraints= {
		@UniqueConstraint(name="uk_artist_id",columnNames={"artist_id"})
		})
public class Artist<E extends Serializable> extends LongIdGidName<String,String> implements BaseEntity,
																							MutableArtistIdEntity<Long>,
																							AritistCreditStreamableEntity<ArtistCredit<?>>,
																							MutableArtistSortNameEntity<ArtistSortName<?>>,
																							MutableArtistCommentEntity<ArtistComment<?>>,
																							MutableArtistBeginDateEntity<ArtistBeginDate>,
																							MutableArtistEndDateEntity<ArtistEndDate>,
																							MutableArtistTypeEntity<ArtistType<Artist<?>>>,
																							MutableGenderEntity<Gender>,
																							MutableAreaEntity<Area>{
	
	private static final long serialVersionUID = -932806802235346847L;

	@Column(name="artist_id" , nullable = false , insertable = true , updatable = false)
	private Long artistId;
	
	@ManyToMany(mappedBy = "artists",fetch=FetchType.LAZY)
	public AritistCreditStreamableEntity<ArtistCredit<?>> artistCredits;

	@NotNull
	@OneToOne(optional=false)
	@JoinTable(
			  name = "artist_sortname_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "sort_name_id",referencedColumnName = "id") )
	public ArtistSortName<?> artistSortName;
	
	
	@OneToOne
	@JoinTable(
			  name = "artist_comment_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "comment_id",referencedColumnName = "id") )
	public ArtistComment<?> artistComment;
	
	@OneToOne
	@JoinTable(
			  name = "artist_begin_date_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	public ArtistBeginDate artistBeginDate; 
	
	@OneToOne
	@JoinTable(
			  name = "artist_end_date_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id"))
	public ArtistEndDate artistEndDate;
	
	@NotNull
	@ManyToOne(optional = false)
	public ArtistType<Artist<?>> type; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(
			  name = "artist_gender_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "gender_id",referencedColumnName = "id"))
	private Gender gender; 

	@ManyToOne
	@JoinTable(
			  name = "artist_area_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "area_id",referencedColumnName = "id"))
	private Area area;

	
	@ManyToOne
	@JoinTable(
			  name = "artist_begin_area_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "area_id",referencedColumnName = "id"))
	private Area beginArea;
	
	@ManyToOne
	@JoinTable(
			  name = "artist_end_area_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "area_id",referencedColumnName = "id"))
	private Area endArea;
	
	public Artist() {
	}
	
	public Artist(
			@NotBlank Long id, 
			@NotBlank String name, 
			@NotBlank String gid) {
		super(gid,name);
		this.artistId = id;
	}
	

}
