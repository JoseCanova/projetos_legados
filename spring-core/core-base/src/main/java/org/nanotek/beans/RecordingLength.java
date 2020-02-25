package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="recording_length")
public class RecordingLength extends EntityLongBase {
	
	private static final long serialVersionUID = -8708909035267715010L;
	
	@JsonIgnore
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Recording recording;
	
	@NotNull
	@Column(name="length")
	private Long length;
	
	public RecordingLength() {}

	public RecordingLength(Recording recording, @NotNull Long length) {
		super();
		this.recording = recording;
		this.length = length;
		this.id = recording.getId();
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Recording getRecording() {
		return recording;
	}

}
