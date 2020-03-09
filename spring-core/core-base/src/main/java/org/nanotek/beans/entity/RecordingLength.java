package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value="RecordingLength")
public class RecordingLength extends LongLengthyBase {
	
	private static final long serialVersionUID = -8708909035267715010L;
	
	@NotNull
	@OneToOne(fetch = FetchType.LAZY , mappedBy = "recordingLenght")
	private Recording recording;
	
	public RecordingLength() {}
	
	public RecordingLength(@NotNull Long length) {
		super(length);
	}

	public RecordingLength(Recording recording, @NotNull Long length) {
		super(length);
		this.recording = recording;
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
		result = prime * result + ((recording == null) ? 0 : recording.hashCode());
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
		RecordingLength other = (RecordingLength) obj;
		if (recording == null) {
			if (other.recording != null)
				return false;
		} else if (!recording.equals(other.recording))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecordingLength [recording=" + recording + ", length=" + length + ", id=" + id + "]";
	}
	
}
