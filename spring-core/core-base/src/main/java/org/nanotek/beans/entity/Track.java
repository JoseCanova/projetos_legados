package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@SuppressWarnings("serial")
@Entity
@Table(name="track")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Track extends LongIdGidNameEntity {

	@Column(name="MEDIUM")
	private Long medium; 
	
	@OneToOne
	@JoinTable(
			  name = "track_position_join", 
			  joinColumns = @JoinColumn(name = "track_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "position_id",referencedColumnName = "id"))
	private TrackPosition position;
	
	
	@Column(name="NUMBER")
	private String number; 
	
	@Column(name="ARTIST_CREDIT")
	private Long artistCredit; 
	
	@Column(name="LENGTH")
	private Long length;
	
	@ManyToOne(fetch=FetchType.LAZY , optional = false)
	@JoinColumn(name="recordingId" , referencedColumnName="id")
	private Recording recording;
	
	/*
	 * public Long getId() { return id; }
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMedium() {
		return medium;
	}
	public void setMedium(Long medium) {
		this.medium = medium;
	}
	
	public TrackPosition getPosition() {
		return position;
	}
	public void setPosition(TrackPosition position) {
		this.position = position;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getArtistCredit() {
		return artistCredit;
	}
	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
	}
	
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}

}
