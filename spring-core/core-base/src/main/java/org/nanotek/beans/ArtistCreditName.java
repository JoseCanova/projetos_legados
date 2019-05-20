package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_credit_name")
@NamedQuery(name="FindArtistCreditByMbid" , query= "Select a from ArtistCreditName a where a.artist = :mbid")
public class ArtistCreditName implements Base<Long> {

	@Id
	@GeneratedValue(generator="artist_credit_name_id_seq" , strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "artist_credit_name_id_seq", sequenceName = "artist_credit_name_id_seq")
	private Long id;
	@Column(name="ARTIST_CREDIT",insertable=true)
	private Long artistCredit; 
	@Column(name="ARTIST_CREDIT_NAME_POSITION",insertable=true)
	private Long position; 
	@Column(name="ARTIST_CREDIT_ARTIST_NAME",insertable=true)
	private Long artist;
	@Column(name="ARTIST_NAME" ,length=1000,nullable=false,insertable=true)
	private String name;
	@Column(name="artist_credit_name_join_prase" ,length=2000,nullable=true,insertable=true)
	private String joinPhrase;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getArtistCredit() {
		return artistCredit;
	}
	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
	}
	
	public Long getPosition() {
		return position;
	}
	public void setPosition(Long position) {
		this.position = position;
	}
	
	public Long getArtist() {
		return artist;
	}
	public void setArtist(Long artist) {
		this.artist = artist;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result
				+ ((artistCredit == null) ? 0 : artistCredit.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (artistCredit == null) {
			if (other.artistCredit != null)
				return false;
		} else if (!artistCredit.equals(other.artistCredit))
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
		return "ArtistCreditName [id=" + id + ", artistCredit=" + artistCredit
				+ ", position=" + position + ", artist=" + artist + ", name="
				+ name + ", joinPhrase=" + joinPhrase + "]";
	}
}
