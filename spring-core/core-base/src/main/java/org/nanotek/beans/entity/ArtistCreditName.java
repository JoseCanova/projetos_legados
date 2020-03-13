package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.nanotek.ArtistCreditBase;
import org.nanotek.ArtistCreditNameIdBase;

@Entity
@DiscriminatorValue(value="ArtistCreditName")
public class ArtistCreditName extends LongIdNameEntity implements ArtistCreditNameIdBase<Long>, ArtistCreditBase<ArtistCredit>{

	private static final long serialVersionUID = -5124525598245692335L;

	@NotNull
	@Column(name="artist_credit_name_id" , nullable=false)
	private Long artistCreditNameId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist_credit_id" , insertable = true , nullable = true, referencedColumnName = "id")
	private ArtistCredit artistCredit;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artistid" , insertable = true , nullable = true, referencedColumnName = "id")
	private Artist artist;
	
	@Column(name="ARTIST_CREDIT_NAME_POSITION",nullable = true , insertable=true)
	private Long position; 
	
	@Column(name="artist_credit_name_join_prase" ,length=2000,nullable=true,insertable=true)
	private String joinPhrase;

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
	
	@Override
	public Long getArtistCreditNameId() {
		return artistCreditNameId;
	}
	
	@Override
	public void setArtistCreditNameId(Long k) {
		this.artistCreditNameId = k;
	}

}
