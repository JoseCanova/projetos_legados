package org.nanotek.beans.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.nanotek.MutableBase;
import org.nanotek.NameBase;

@Entity
@Table(name="artist")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Artist extends EntityLongBase implements MutableBase<Long> , NameBase {
	
	private static final long serialVersionUID = -932806802235346847L;

	@NotNull
	@Length(min = 1 , max = 1000)
	@Column(name="name",length=1000,nullable=false)
	private String name;
	
	@NotNull
	@Length(min = 1 , max = 1000)
	@Column(name="sort_name",length=1000,nullable=false)
	private String sortName;

	@ManyToMany(mappedBy = "artists",fetch=FetchType.LAZY)
	private List<ArtistCredit> artistCredits;

	@NotNull
	@Length(min = 1 , max = 40)
	@Column(name="gid", nullable=false)
	private String gid;
	
	@OneToOne(mappedBy = "artist" , fetch = FetchType.LAZY , optional = true)
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
	
	public Artist(@NotNull Long id, @NotNull @Length(min = 1, max = 1000) String name, @NotNull @Length(min = 1, max = 40) String gid,
			@NotNull String sortName) {
		super(id);
		this.name = name;
		this.gid = gid;
		this.sortName = sortName;
	}
	
	public Artist(@NotNull Long id, @NotNull @Length(min = 1, max = 1000) String name,
			@NotNull @Length(min = 1, max = 1000) String sortName, List<ArtistCredit> artistCredits,
			@NotNull @Length(min = 1, max = 40) String gid, ArtistComment artistComment,
			ArtistBeginDate artistBeginDate, ArtistEndDate artistEndDate, @NotNull ArtistType type, Gender gender,
			Area beginArea, Area endArea) {
		super(id);
		this.name = name;
		this.sortName = sortName;
		this.artistCredits = artistCredits;
		this.gid = gid;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public List<ArtistCredit> getArtistCredits() {
		return artistCredits;
	}

	public void setArtistCredits(List<ArtistCredit> artistCredits) {
		this.artistCredits = artistCredits;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
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
		result = prime * result + ((artistBeginDate == null) ? 0 : artistBeginDate.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sortName == null) ? 0 : sortName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (artistBeginDate == null) {
			if (other.artistBeginDate != null)
				return false;
		} else if (!artistBeginDate.equals(other.artistBeginDate))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
