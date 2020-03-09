package org.nanotek.beans.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="artist" , 
		uniqueConstraints= {
		@UniqueConstraint(name="uk_artist_gid",columnNames={"gid"}),
		@UniqueConstraint(name="uk_artist_id",columnNames={"artist_id"})
		},
		indexes= {
					@Index(unique = false , name = "artist_name_idx" , columnList ="name"),
					@Index(unique = false , name = "artist_sort_name_idx" , columnList ="sort_name")
				})
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Artist extends LongIdGidSortNameEntity {
	
	private static final long serialVersionUID = -932806802235346847L;

	@Column(name="artist_id" , nullable = false , insertable = true , updatable = false)
	private Long artistId;
	
	@ManyToMany(mappedBy = "artists",fetch=FetchType.LAZY)
	private List<ArtistCredit> artistCredits;

	@OneToOne
	@JoinTable(
			  name = "artist_comment_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "commentS_id",referencedColumnName = "id") )
	private ArtistComment artistComment;
	
	@OneToOne
	@JoinTable(
			  name = "artist_begin_date_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private ArtistBeginDate artistBeginDate; 
	
	@OneToOne
	@JoinTable(
			  name = "artist_end_date_join", 
			  joinColumns = @JoinColumn(name = "artist_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id"))
	private ArtistEndDate artistEndDate;
	
	@NotNull
	@ManyToOne(optional = false)
	private ArtistType type; 
	
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
			@NotBlank String gid,
			@NotNull String sortName) {
		super(name,sortName,gid);
		this.artistId = id;
	}
	
	public Artist(
			@NotNull Long id, 
			@NotBlank String name,
			@NotBlank String sortName, 
			List<ArtistCredit> artistCredits,
			@NotBlank String gid, 
			ArtistComment artistComment,
			ArtistBeginDate artistBeginDate, 
			ArtistEndDate artistEndDate, 
			@NotNull ArtistType type, 
			Gender gender,
			Area beginArea, 
			Area endArea) {
		super(name,sortName,gid);
		this.artistId = id;
		this.artistCredits = artistCredits;
		this.artistComment = artistComment;
		this.artistBeginDate = artistBeginDate;
		this.artistEndDate = artistEndDate;
		this.type = type;
		this.gender = gender;
		this.beginArea = beginArea;
		this.endArea = endArea;
	}

	public void setId(Long id) { 
		this.id = id;
	}
	
	public List<ArtistCredit> getArtistCredits() {
		return artistCredits;
	}

	public void setArtistCredits(List<ArtistCredit> artistCredits) {
		this.artistCredits = artistCredits;
	}

	public ArtistComment getArtistComment() {
		return artistComment;
	}

	public void setArtistComment(ArtistComment artistComment) {
		this.artistComment = artistComment;
	}

	public ArtistBeginDate getArtistBeginDate() {
		return artistBeginDate;
	}

	public void setArtistBeginDate(ArtistBeginDate artistBeginDate) {
		this.artistBeginDate = artistBeginDate;
	}

	public ArtistEndDate getArtistEndDate() {
		return artistEndDate;
	}

	public void setArtistEndDate(ArtistEndDate artistEndDate) {
		this.artistEndDate = artistEndDate;
	}

	public ArtistType getType() {
		return type;
	}

	public void setType(ArtistType type) {
		this.type = type;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Area getBeginArea() {
		return beginArea;
	}

	public void setBeginArea(Area beginArea) {
		this.beginArea = beginArea;
	}

	public Area getEndArea() {
		return endArea;
	}

	public void setEndArea(Area endArea) {
		this.endArea = endArea;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artistId == null) ? 0 : artistId.hashCode());
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
		Artist other = (Artist) obj;
		if (artistId == null) {
			if (other.artistId != null)
				return false;
		} else if (!artistId.equals(other.artistId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistCredits=" + artistCredits + ", artistComment=" + artistComment
				+ ", artistBeginDate=" + artistBeginDate + ", artistEndDate=" + artistEndDate + ", type=" + type
				+ ", gender=" + gender + ", area=" + area + ", beginArea=" + beginArea + ", endArea=" + endArea
				+ ", gid=" + gid + ", sortName=" + sortName + ", name=" + name + ", id=" + id + "]";
	}
	
}
