package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="track")
public class Track implements Base<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="track_id_seq")
	@SequenceGenerator(name="track_id_seq",sequenceName="track_id_seq")
	private Long id; 
	@Column(name="TRACK_ID")
	private Long trackId; 
	@Column(name="GID" , length=255)
	private String gid;
	@Column(name="RECORDING")
	private Long recordingId; 
	@Column(name="MEDIUM")
	private Long medium; 
	@Column(name="POSITION")
	private Integer position;
	@Column(name="NUMBER")
	private Integer number; 
	@Column(name="NAME" , length=1000)
	private String name; 
	@Column(name="ARTIST_CREDIT")
	private Long artistCredit; 
	@Column(name="LENGTH")
	private Long length;
	
/*	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="recording" , referencedColumnName="recording_id")
	private Recording recording;*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getTrackId() {
		return trackId;
	}
	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	
/*	public Recording getRecording() {
		return recording;
	}
	public void setRecording(Recording recording) {
		this.recording = recording;
	}*/
	
	public Long getMedium() {
		return medium;
	}
	public void setMedium(Long medium) {
		this.medium = medium;
	}
	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
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
	
	public Long getRecordingId() {
		return recordingId;
	}
	
	public void setRecordingId(Long recordingId) {
		this.recordingId = recordingId;
	}
	
	
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trackId == null) ? 0 : trackId.hashCode());
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
		return "Track [id=" + id + ", trackId=" + trackId + ", gid=" + gid
				/*+ ", recording=" + recording */+ ", medium=" + medium
				+ ", position=" + position + ", number=" + number + ", name="
				+ name + ", artistCredit=" + artistCredit + ", lenght="
				+ length + "]";
	}

}
