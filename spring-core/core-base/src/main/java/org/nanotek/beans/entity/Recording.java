package org.nanotek.beans.entity;

import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="recording" ,
uniqueConstraints= {
@UniqueConstraint(name="uk_recording_id",columnNames={"recording_id"})
})
public class Recording extends LongIdGidNameEntity {

	private static final long serialVersionUID = 1795844351898160253L;

	@NotNull
	@Column(name="recording_id" , nullable=false)
	private Long recordingId;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_credit_id" , referencedColumnName="id")
	private ArtistCredit artistCredit; 
	
	@OneToMany(mappedBy="recording" , fetch=FetchType.LAZY)
	private Set<Track> tracks;
	
	@OneToOne(fetch = FetchType.LAZY)
	private RecordingLength recordingLenght;
	
	public Recording() {}
	
	public Recording(@NotNull Long id , @NotBlank @Length(min = 1, max = 50) String gid, @NotNull String name) {
		super(gid, name);
		this.recordingId = id;
	}
	
	public Recording(@NotBlank @Length(min = 1, max = 50) String gid, @NotNull String name) {
		super(gid, name);
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}

	public RecordingLength getRecordingLenght() {
		return recordingLenght;
	}

	public void setRecordingLenght(RecordingLength recordingLenght) {
		this.recordingLenght = recordingLenght;
	}

	public Long getRecordingId() {
		return recordingId;
	}

	public void setRecordingId(Long recordingId) {
		this.recordingId = recordingId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((recordingId == null) ? 0 : recordingId.hashCode());
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
		return "Recording [recordingId=" + recordingId + ", artistCredit=" + artistCredit + ", tracks=" + tracks
				+ ", recordingLenght=" + recordingLenght + ", gid=" + gid + ", name=" + name + ", id=" + id + "]";
	}
	
}
