package org.nanotek.beans;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;
import org.nanotek.Transferable;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_name")
@NamedQuery(name = "ArtistName.LoadAll", query ="Select a from ArtistName a order by a.id asc")
public class ArtistName implements Base<Long> {

	@Id
	@GeneratedValue(generator="artist_name_id_seq",strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name = "artist_name_id_seq", sequenceName = "artist_name_id_seq")
	private Long id; 
	@Column(name="name",length=1000,nullable=false)
	private String name;
	@Column(name="SORT_NAME",length=1000,nullable=true)
	private String sortName;
	@OneToMany
	@JoinTable(name="ARTIST_CREDIT_NAME",
	joinColumns={ @JoinColumn(name="artist_credit_artist_name", referencedColumnName="mbid") },
	inverseJoinColumns={ @JoinColumn(name="artist_credit", referencedColumnName="artist_credit_id", unique=true) })
	private Set<ArtistCredit> artistCredits;

	@Column(name="mbid", nullable=true)
	private Long mbid; 

	@Column(name="gid", nullable=true)
	private String gid; 
	@Column(name="type", nullable=true)
    private Integer type;
	@Column(name="country", nullable=true)
    private Integer country;
	@Column(name="gender", nullable=true)
    private Integer gender;
    

	public ArtistName() {
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
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

/*	public Long getMbid() {
		return mbid;
	}

	public void setMbid(Long mbid) {
		this.mbid = mbid;
	}*/

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Set<ArtistCredit> getArtistCredits() {
		return artistCredits != null ? artistCredits : (artistCredits = newAnyType(HashSet::new));  //ofNullable(HashSet::new, artistCredits); //Optional.ofNullable(artistCredits).orElseGet(HashSet::new);
	}

	public void setArtistCredits(Set<ArtistCredit> artistCredits) {
		this.artistCredits = artistCredits;
	}

	public Long getMbid() {
		return mbid;
	}

	public void setMbid(Long mbid) {
		this.mbid = mbid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		/*result = prime * result + ((mbid == null) ? 0 : mbid.hashCode());*/
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((sortName == null) ? 0 : sortName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistName other = (ArtistName) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (mbid == null) {
			if (other.mbid != null)
				return false;
		} else if (!mbid.equals(other.mbid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistName [id=" + id + ", name=" + name + ", sortName="
				+ sortName + ", mbid=" + mbid + ", gid=" + gid + "]";
	}
	/*"*/
}
