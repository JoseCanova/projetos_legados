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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="track")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Track extends LongIdGidNameEntity {

	private static final long serialVersionUID = 8642862162010029043L;

	@Column(name="MEDIUM")
	private Long medium; 
	
	@OneToOne
	@JoinTable(
			  name = "track_position_join", 
			  joinColumns = @JoinColumn(name = "track_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "position_id",referencedColumnName = "id"))
	private TrackPosition position;
	
	@NotNull
	@OneToOne(optional=false)
	@JoinTable(
			  name = "track_number_join", 
			  joinColumns = @JoinColumn(name = "track_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "number_id",referencedColumnName = "id"))
	private String number; 
	
	@NotNull
	@ManyToOne(optional=false)
	private ArtistCredit artistCredit; 
	
	@NotNull
	@OneToOne(optional=false)
	@JoinTable(
			  name = "track_length_join", 
			  joinColumns = @JoinColumn(name = "track_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "length_id",referencedColumnName = "id"))
	private TrackLength length;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY , optional = false)
	@JoinColumn(name="recordingId" , referencedColumnName="id")
	private Recording recording;
	
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
	
	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}
	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}
	
	public TrackLength getLength() {
		return length;
	}
	public void setLength(TrackLength length) {
		this.length = length;
	}

}
