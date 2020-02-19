package org.nanotek.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.LongBase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@SuppressWarnings("serial")
@Entity
@Table(name="artist_credit")
@NamedQueries(value = { 
		@NamedQuery(name = "FindArtistCreditById", query ="Select a from ArtistCredit a where a.artistCreditId = :artistCreditId"),
		@NamedQuery(name = "ArtistCreditLoadAll", query ="Select a from ArtistCredit a order by a.id asc"),
		@NamedQuery(name="FindArtistCredits" , query = "Select a from ArtistCredit a where a.artistCreditId in (:ids)"),
		@NamedQuery(name="ArtistCredit.findByArtistCreditId" , query="Select a from ArtistCredit a left outer join a.releases where a.artistCreditId = :id")
})
public class ArtistCredit implements LongBase {

//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="artist_credit_id_seq")
//	@SequenceGenerator(name = "artist_credit_id_seq", sequenceName = "artist_credit_id_seq")
//	private Long id;
//	@Column(name="id" , insertable=true,nullable=false,unique = true)
	@Id
	private Long id;
	@Column (name="artist_name" ,length=1000, insertable=true,nullable=false)
	private String name; 
	@Column (name="artist_count")
	private Long artistCount; 
	@Column (name="ref_count")
	private Long refCount;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="artistCreditReference")
	private Set<Release> releases; 

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="artist_credit_name_rel",
	inverseJoinColumns={@JoinColumn(name="artist_name_id", referencedColumnName="id") },
	joinColumns={ @JoinColumn(name="artist_credit_id", referencedColumnName="id") })
	private List<Artist> artists;
	
/*	@OneToMany(fetch=FetchType.LAZY,mappedBy="artistCreditReference")
	private Set<Recording> recordings; */
	
	public void setId(Long id) {
		this.id = id;
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

	public Long getArtistCount() {
		return artistCount;
	}

	public void setArtistCount(Long artistCount) {
		this.artistCount = artistCount;
	}

	public Long getRefCount() {
		return refCount;
	}

	public void setRefCount(Long refCount) {
		this.refCount = refCount;
	}

	public Set<Release> getReleases() {
		return releases != null ? releases : (releases = newAnyType(HashSet::new)); 
	}

	public void setReleases(Set<Release> releases) {
		this.releases = releases;
	}
	
	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

}
