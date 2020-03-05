package org.nanotek.beans.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
	
	@OneToOne(mappedBy = "artist" , fetch = FetchType.LAZY)
	private ArtistComment artistComment;
	/*
	 * @Column(name="type", nullable=true) private Integer type;
	 * 
	 * @Column(name="country", nullable=true) private Integer country;
	 * 
	 * @Column(name="gender", nullable=true) private Integer gender;
	 */
	
	public Artist() {
	}

	public Artist(Long artistId , String name , String sortName , String gid) { 
		this.id = artistId; 
		this.name = name; 
		this.sortName = sortName; 
		this.gid = gid;
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

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}


	public List<ArtistCredit> getArtistCredits() {
		return artistCredits != null ? artistCredits : (artistCredits = newAnyType(ArrayList::new));  //ofNullable(HashSet::new, artistCredits); //Optional.ofNullable(artistCredits).orElseGet(HashSet::new);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
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
		Artist other = (Artist) obj;
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
		return true;
	}
	
}
