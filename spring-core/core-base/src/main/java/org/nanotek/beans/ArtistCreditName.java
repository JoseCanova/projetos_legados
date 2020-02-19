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
import org.nanotek.LongBase;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_credit_name")
//@NamedQuery(name="FindArtistCreditByMbid" , query= "Select a from ArtistCreditName a where a.artistName.artistid = :mbid")
public class ArtistCreditName implements LongBase {

	@Id
	@GeneratedValue(generator="artist_credit_name_id_seq" , strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "artist_credit_name_id_seq", sequenceName = "artist_credit_name_id_seq")
	private Long id;
	//	@Column(name="ARTIST_CREDIT",insertable=true)
	//	private Long artistCredit; 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_credit_id" , insertable = true , nullable = true, referencedColumnName = "id")
	private ArtistCredit artistCredit;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artistid" , insertable = true , nullable = true, referencedColumnName = "id")
	private Artist artist;
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

	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	public static ArtistCreditName NULL_VALUE() {
		Optional<ArtistCreditName> a = Base.NULL_VALUE(ArtistCreditName.class);
		ArtistCreditName acn = null;
		acn = a.get();
		acn.setId(0l);
		return Optional.of(acn).orElse(null);
	}
	
}
