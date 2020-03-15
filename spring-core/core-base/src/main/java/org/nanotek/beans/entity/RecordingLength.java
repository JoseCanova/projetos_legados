package org.nanotek.beans.entity;

import java.util.function.Consumer;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.nanotek.ImmutableLengthIdBase;

@Entity
@Table(name="recording_lengthy_base",
						indexes= {
								@Index(unique = false , name = "long_length_table_idx" , columnList ="length")
							})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
@DiscriminatorValue(value="RecordingLength")
public class RecordingLength extends LongLengthyBase implements ImmutableLengthIdBase<RecordingLength,Long,Long>{
	
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
