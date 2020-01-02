package org.nanotek.beans.flat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.LongBase;

@Entity
@Table(name="artist_credit_name")
public class FlatArtistCreditName implements LongBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7128072634391448669L;
	
	@Id
	@GeneratedValue(generator="artist_credit_name_id_seq" , strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "artist_credit_name_id_seq", sequenceName = "artist_credit_name_id_seq")
	private Long id;
	@Column(name = "artist_credit_id")
	private Long artistCredit; 
	@Column(name="artist_credit_name_position")
	private Long position; 
	@Column(name="artistid")
	private Long artist; 
	@Column(name="artist_name")
	private String name; 
	@Column (name = "artist_credit_name_join_prase")
	private String joinPhrase;
	
	public FlatArtistCreditName() {}
	
	public FlatArtistCreditName(Long id, Long artistCredit, Long position, Long artist, String name, String joinPhrase) {
		super();
		this.artistCredit = artistCredit;
		this.position = position;
		this.artist = artist;
		this.name = name;
		this.joinPhrase = joinPhrase;
	}
	
	static FlatArtistCreditName of(Long artistCredit, Long position, Long artist, String name, String joinPhrase) { 
	    return new FlatArtistCreditName(null, artistCredit, position, artist, name , joinPhrase);
	}

	FlatArtistCreditName withId(Long id) {
		    return new FlatArtistCreditName(id, this.artistCredit, this.position , this.artist , this.name , this.joinPhrase);
	 }
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJoinPhrase() {
		return joinPhrase;
	}

	public void setJoinPhrase(String joinPhrase) {
		this.joinPhrase = joinPhrase;
	}
	
	
	
}
