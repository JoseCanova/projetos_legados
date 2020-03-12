package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="track")
public class Track extends LongIdGidNameEntity {

	private static final long serialVersionUID = 8642862162010029043L;

	@Column(name="track_id")
	private Long trackId;
	
	@ManyToOne(optional=false)
	private Medium medium; 
	
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
	private TrackNumber number; 
	
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
	
	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	
	public TrackPosition getPosition() {
		return position;
	}
	public void setPosition(TrackPosition position) {
		this.position = position;
	}
	
	public TrackNumber getNumber() {
		return number;
	}
	public void setNumber(TrackNumber number) {
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
	public Long getTrackId() {
		return trackId;
	}
	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}
	public Recording getRecording() {
		return recording;
	}
	public void setRecording(Recording recording) {
		this.recording = recording;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((trackId == null) ? 0 : trackId.hashCode());
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
		Track other = (Track) obj;
		if (trackId == null) {
			if (other.trackId != null)
				return false;
		} else if (!trackId.equals(other.trackId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", medium=" + medium + ", position=" + position + ", number=" + number
				+ ", artistCredit=" + artistCredit + ", length=" + length + ", recording=" + recording + ", gid=" + gid
				+ ", name=" + name + ", id=" + id + "]";
	}

	
	
}
