package org.nanotek.beans.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
@Table(name="artist_credit")
@NamedQueries(value = { 
		@NamedQuery(name = "FindArtistCreditById", query ="Select a from ArtistCredit a where a.id = :id"),
		@NamedQuery(name = "ArtistCreditLoadAll", query ="Select a from ArtistCredit a order by a.id asc"),
		@NamedQuery(name="FindArtistCredits" , query = "Select a from ArtistCredit a where a.id in (:ids)"),
		@NamedQuery(name="ArtistCredit.findByArtistCreditId" , query="Select a from ArtistCredit a left outer join a.releases where a.id = :id")
})
@NamedEntityGraph( name = "fetch.ArtistCredit.recordings",
					attributeNodes = {@NamedAttributeNode(value="recordings",subgraph = "recordings")},
					subgraphs = @NamedSubgraph(name = "recordings", 
					attributeNodes = {@NamedAttributeNode(value="recordingLenght" , subgraph = "recordingLenght")}
))
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ArtistCredit extends LongIdNameEntity {
	
	private static final long serialVersionUID = -3086006757943654550L;
	
	@NotNull
	@Column(name="artist_credit_id" , nullable=false)
	private Long artistCreditId;
	
	@NotNull
	@Column (name="artist_count" , insertable=true,nullable=false,updatable = true)
	private Long artistCount; 
	
	@NotNull
	@Column (name="ref_count" , insertable=true,nullable=false,updatable = true)
	private Long refCount;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="artistCredit")
	private Set<Release> releases; 

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="artist_credit_name_rel",
	inverseJoinColumns={@JoinColumn(name="artist_name_id", referencedColumnName="id") },
	joinColumns={ @JoinColumn(name="artist_credit_id", referencedColumnName="id") })
	private List<Artist> artists;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="artistCredit")
	private Set<Recording> recordings; 
	
	public ArtistCredit() {}
	
	public ArtistCredit(@NotNull Long id , @NotBlank String name, @NotNull Long artistCount,
			@NotNull Long refCount, Set<Recording> recordings) {
		super(name);
		this.artistCreditId = id;
		this.artistCount = artistCount;
		this.refCount = refCount;
		this.recordings = recordings;
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

	public Set<Recording> getRecordings() {
		return recordings;
	}

	public void setRecordings(Set<Recording> recordings) {
		this.recordings = recordings;
	}

	public Long getArtistCreditId() {
		return artistCreditId;
	}

	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artistCreditId == null) ? 0 : artistCreditId.hashCode());
		result = prime * result + ((recordings == null) ? 0 : recordings.hashCode());
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
		ArtistCredit other = (ArtistCredit) obj;
		if (artistCreditId == null) {
			if (other.artistCreditId != null)
				return false;
		} else if (!artistCreditId.equals(other.artistCreditId))
			return false;
		if (recordings == null) {
			if (other.recordings != null)
				return false;
		} else if (!recordings.equals(other.recordings))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistCredit [artistCreditId=" + artistCreditId + ", artistCount=" + artistCount + ", refCount="
				+ refCount + ", releases=" + releases + ", artists=" + artists + ", recordings=" + recordings
				+ ", name=" + name + ", id=" + id + "]";
	}
}
