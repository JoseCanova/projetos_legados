package org.nanotek.beans.entity;

import java.io.Serializable;

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

import org.nanotek.collections.MutableArtistCreditList;
import org.nanotek.entities.BaseArtistEntity;

@Entity
@Table(name="artist" , 
		uniqueConstraints= {
		@UniqueConstraint(name="uk_artist_id",columnNames={"artist_id"})
		})
public class Artist<K extends Serializable> extends LongIdGidName<String,String> implements BaseArtistEntity<K>{
	
	private static final long serialVersionUID = -932806802235346847L;

	@Column(name="artist_id" , nullable = false , insertable = true , updatable = false)
	public Long artistId;
	
	@ManyToMany(mappedBy = "artists",fetch=FetchType.LAZY , targetEntity=org.nanotek.beans.entity.ArtistCredit.class)
	public MutableArtistCreditList<ArtistCredit<?>> artistCredits;

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
	public ArtistType<Artist<?>> artistType; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(
			  name = "artist_gender_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "gender_id",referencedColumnName = "id"))
	public Gender gender; 

	@ManyToOne
	@JoinTable(
			  name = "artist_area_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "area_id",referencedColumnName = "id"))
	public Area<Artist<?>> area;

	
	@ManyToOne
	@JoinTable(
			  name = "artist_begin_area_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "area_id",referencedColumnName = "id"))
	public Area<Artist<?>> beginArea;
	
	@ManyToOne
	@JoinTable(
			  name = "artist_end_area_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "area_id",referencedColumnName = "id"))
	public Area<Artist<?>> endArea;
	
	public Artist() {
		artistCredits = new MutableArtistCreditList<ArtistCredit<?>>();
	}
	
	public Artist(
			@NotBlank Long id, 
			@NotBlank String name, 
			@NotBlank String gid) {
		super(gid,name);
		this.artistId = id;
		artistCredits = new MutableArtistCreditList<ArtistCredit<?>>();
	}

	@Override
	public void setArtistId(Long k) {
		this.artistId = k;
	}

	@Override
	public Long getArtistId() {
		return artistId;
	}

	@Override
	public void setArtistSortName(ArtistSortName<?> k) {
		this.artistSortName = k;
	}

	@Override
	public ArtistSortName<?> getArtistSortName() {
		return this.artistSortName;
	}

	@Override
	public void setArtistComment(ArtistComment<?> k) {
		this.artistComment = k;
	}

	@Override
	public ArtistComment<?> getArtistComment() {
		return this.artistComment;
	}

	@Override
	public void setArtistBeginDate(ArtistBeginDate k) {
		this.artistBeginDate = k;
	}

	@Override
	public ArtistBeginDate getArtistBeginDate() {
		return this.artistBeginDate;
	}

	@Override
	public void setArtistEndDate(ArtistEndDate k) {
		this.artistEndDate = k;
	}

	@Override
	public ArtistEndDate getArtistEndDateEntity() {
		return this.artistEndDate;
	}

	@Override
	public void setArtistType(ArtistType<Artist<?>> k) {
		this.artistType = k;
	}

	@Override
	public ArtistType<Artist<?>> getArtistType() {
		return this.artistType;
	}

	@Override
	public void setGender(Gender k) {
		this.gender = k;
	}

	@Override
	public Gender getGender() {
		return this.gender;
	}

	@Override
	public void setArea(Area<Artist<?>> k) {
		this.area = k;
	}

	@Override
	public Area<Artist<?>> getArea() {
		return this.area;
	}

}
