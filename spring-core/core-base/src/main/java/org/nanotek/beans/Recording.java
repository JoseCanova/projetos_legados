package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")@Entity
@Table(name="RECORDING")
public class Recording implements Base<Long> {

	@Id
	@GeneratedValue(generator="recording_id_seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="recording_id_seq",sequenceName="recording_id_seq")
	private Long id; 
	@Column(name="RECORDING_ID" , insertable=true)
	private Long recordingId; 
	@Column(name="GID" , length=255 , insertable=true)
	private String gid; 
	@Column(name="NAME" , length=2500 , nullable=false , insertable=true)
	private String name; 
	@Column(name="ARTIST_CREDIT" , nullable=false , insertable=true)
	private Long artistCredit;
	@Column(name="LENGTH" , nullable=true , insertable=true)
	private Long length;
	@Column(name="COMMENT" , length=2500  , nullable=true , insertable=true)
	private String comment;
	
/*	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_credit" , referencedColumnName="artist_credit_id")
	private ArtistCredit artistCreditReference; */
/*	
	@OneToMany(mappedBy="recording" , fetch=FetchType.LAZY)
	private Set<Track> tracks;*/
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getRecordingId() {
		return recordingId;
	}

	public void setRecordingId(Long recordingId) {
		this.recordingId = recordingId;
	}
	
	public String getGid() {
		return gid;
	}
	
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public Long getArtistCredit() {
		return artistCredit;
	}
	
	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

/*	public ArtistCredit getArtistCreditReference() {
		return artistCreditReference;
	}

	public void setArtistCreditReference(ArtistCredit artistCreditReference) {
		this.artistCreditReference = artistCreditReference;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((recordingId == null) ? 0 : recordingId.hashCode());
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
		Recording other = (Recording) obj;
		if (recordingId == null) {
			if (other.recordingId != null)
				return false;
		} else if (!recordingId.equals(other.recordingId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recording [id=" + id + ", recordingId=" + recordingId
				+ ", gid=" + gid + ", artistCredit=" + artistCredit + ", name="
				+ name + ", length=" + length + ", comment=" + comment + "]";
	}

}
