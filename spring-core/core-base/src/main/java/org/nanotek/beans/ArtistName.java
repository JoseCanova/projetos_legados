package org.nanotek.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.nanotek.Base;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
@SuppressWarnings("serial")
@Entity
@Table(name="artist_name")
@NamedQuery(name = "ArtistName.LoadAll", query ="Select a from ArtistName a order by a.id asc")
public class ArtistName implements Base<Long> {

	@Id
	@GeneratedValue(generator="artist_name_id_seq",strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name = "artist_name_id_seq", sequenceName = "artist_name_id_seq")
	private Long id;
	@NotNull
	@Column(name="artistId",length=1000,nullable=false,unique=true)
	private Long artistId;
	@NotNull
	@Column(name="name",length=1000,nullable=false)
	private String name;
	@NotNull
	@Column(name="sort_name",length=1000,nullable=true)
	private String sortName;

	@ManyToMany(mappedBy = "artists",fetch=FetchType.LAZY)
	private List<ArtistCredit> artistCredits;

	@NotNull
	@Column(name="gid", nullable=false)
	private String gid;
	@Column(name="type", nullable=true)
    private Integer type;
	@Column(name="country", nullable=true)
    private Integer country;
	@Column(name="gender", nullable=true)
    private Integer gender;

	public ArtistName() {
	}

	public ArtistName(Long id , Long artistId , String name , String sortName , String gid) { 
		this.id = id ; 
		this.artistId = artistId; 
		this.name = name; 
		this.sortName = sortName; 
		this.gid = gid;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
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

	public List<ArtistCredit> getArtistCredits() {
		return artistCredits != null ? artistCredits : (artistCredits = newAnyType(ArrayList::new));  //ofNullable(HashSet::new, artistCredits); //Optional.ofNullable(artistCredits).orElseGet(HashSet::new);
	}

	public void setArtistCredits(List<ArtistCredit> artistCredits) {
		this.artistCredits = artistCredits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistId == null) ? 0 : artistId.hashCode());
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sortName == null) ? 0 : sortName.hashCode());
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
		if (artistId == null) {
			if (other.artistId != null)
				return false;
		} else if (!artistId.equals(other.artistId))
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "ArtistName [id=" + id + ", artistId=" + artistId + ", name=" + name + ", sortName=" + sortName
				+ ", artistCredits=" + artistCredits + ", gid=" + gid + ", type=" + type + ", country=" + country
				+ ", gender=" + gender + "]";
	}

}
