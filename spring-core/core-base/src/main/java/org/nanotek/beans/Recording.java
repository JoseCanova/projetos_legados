package org.nanotek.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.nanotek.MutableBase;

@SuppressWarnings("serial")
@Entity
@Table(name="RECORDING")
public class Recording extends SuperLongBase implements MutableBase<Long>{

	@NotNull
	@Size(min= 1 , max=40)
	@Column(name="gid" , length=40 , insertable=true, nullable=true)
	private String gid;
	
	@NotNull
	@Size(min=1 , max=1000)
	@Column(name="name" , length=1000 , nullable=false , insertable=true)
	private String name; 
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="artist_credit_id" , referencedColumnName="id")
	private ArtistCredit artistCredit; 
	
	@OneToMany(mappedBy="recording" , fetch=FetchType.LAZY)
	private Set<Track> tracks;
	
	@OneToOne(mappedBy = "recording" , fetch = FetchType.LAZY)
	private RecordingLength recordingLenght;
	
	public Recording() {}
	
	@Override
	public void setId(Long id) {
		this.id = id; 
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
