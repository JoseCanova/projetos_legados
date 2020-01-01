package org.nanotek.beans.jdbc;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.Id;

public class ArtistCreditName {
	
	private @Id Long id;
	private Long artistCredit; 
	private Integer position; 
	private Long artist; 
	private @AccessType(Type.PROPERTY)  String name; 
	private @AccessType(Type.PROPERTY) String joinPhrase;
	
	public ArtistCreditName() {}
	
	public ArtistCreditName(Long id, Long artistCredit, Integer position, Long artist, String name, String joinPhrase) {
		super();
		this.artistCredit = artistCredit;
		this.position = position;
		this.artist = artist;
		this.name = name;
		this.joinPhrase = joinPhrase;
	}
	
	static ArtistCreditName of(Long artistCredit, Integer position, Long artist, String name, String joinPhrase) { 
	    return new ArtistCreditName(null, artistCredit, position, artist, name , joinPhrase);
	}

	ArtistCreditName withId(Long id) {
		    return new ArtistCreditName(id, this.artistCredit, this.position , this.artist , this.name , this.joinPhrase);
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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
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
