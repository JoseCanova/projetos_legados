package org.nanotek.beans.entity;

import java.util.function.Consumer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.nanotek.ImmutableLengthIdBase;

@Entity
@DiscriminatorValue(value="TrackLength")
public class TrackLength extends LongLengthyBase implements ImmutableLengthIdBase<Long,Long> {

	private static final long serialVersionUID = 3623778681403832594L;
	
	@NotNull
	@OneToOne(optional=false)
	private Track track;
	
	public TrackLength() {
	}

	public TrackLength(@NotNull Long length) {
		super(length);
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((track == null) ? 0 : track.hashCode());
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
		TrackLength other = (TrackLength) obj;
		if (track == null) {
			if (other.track != null)
				return false;
		} else if (!track.equals(other.track))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrackLength [track=" + track + ", length=" + length + ", id=" + id + "]";
	}

	@Override
	public void on(Consumer<Long> k) {
		k.accept(getId());
	}

}
