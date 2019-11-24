package org.nanotek.beans;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_credit_name")
//@NamedQuery(name="FindArtistCreditByMbid" , query= "Select a from ArtistCreditName a where a.artistName.artistid = :mbid")
public class ArtistCreditName implements Base<Long> {

	@Id
	@GeneratedValue(generator="artist_credit_name_id_seq" , strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "artist_credit_name_id_seq", sequenceName = "artist_credit_name_id_seq")
	private Long id;
	//	@Column(name="ARTIST_CREDIT",insertable=true)
	//	private Long artistCredit; 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_credit_id" , insertable = true , nullable = true, referencedColumnName = "artist_credit_id")
	private ArtistCredit artistCredit;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artistid" , insertable = true , nullable = true, referencedColumnName = "artistid")
	private ArtistName artistName;
	@Column(name="ARTIST_CREDIT_NAME_POSITION",nullable = true , insertable=true)
	private Long position; 
	@Column(name="ARTIST_NAME" ,length=1000, nullable = true , insertable=true)
	private String name;
	@Column(name="artist_credit_name_join_prase" ,length=2000,nullable=true,insertable=true)
	private String joinPhrase;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getPosition() {
		return position;
	}
	public void setPosition(Long position) {
		this.position = position;
	}

	public String getJoinPhrase() {
		return joinPhrase;
	}
	public void setJoinPhrase(String joinPhrase) {
		this.joinPhrase = joinPhrase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}

	public ArtistName getArtistName() {
		return artistName;
	}
	public void setArtistName(ArtistName artistName) {
		this.artistName = artistName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistCredit == null) ? 0 : artistCredit.hashCode());
		result = prime * result + ((artistName == null) ? 0 : artistName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joinPhrase == null) ? 0 : joinPhrase.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		ArtistCreditName other = (ArtistCreditName) obj;
		if (artistCredit == null) {
			if (other.artistCredit != null)
				return false;
		} else if (!artistCredit.equals(other.artistCredit))
			return false;
		if (artistName == null) {
			if (other.artistName != null)
				return false;
		} else if (!artistName.equals(other.artistName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joinPhrase == null) {
			if (other.joinPhrase != null)
				return false;
		} else if (!joinPhrase.equals(other.joinPhrase))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtistCreditName [id=" + id + ", artistCredit=" + artistCredit + ", artistName=" + artistName
				+ ", position=" + position + ", name=" + name + ", joinPhrase=" + joinPhrase + "]";
	}

	public static ArtistCreditName NULL_VALUE() {
		Optional<ArtistCreditName> a = Base.NULL_VALUE(ArtistCreditName.class);
		ArtistCreditName acn = null;
		acn = a.get();
		acn.setId(0l);
		return Optional.of(acn).orElse(null);
	}

}
