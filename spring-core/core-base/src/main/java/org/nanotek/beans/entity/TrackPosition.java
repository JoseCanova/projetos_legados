package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "TrackPosition")
public class TrackPosition extends LongPositionBase {

	private static final long serialVersionUID = 6747130680556082235L;
	
	@NotNull
	@OneToOne(mappedBy = "position" , optional=false)
	private Track track;

	public TrackPosition() {
	}

	public TrackPosition(@NotNull Long position) {
		super(position);
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
		TrackPosition other = (TrackPosition) obj;
		if (track == null) {
			if (other.track != null)
				return false;
		} else if (!track.equals(other.track))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrackPosition [track=" + track + ", position=" + position + ", id=" + id + "]";
	}

}
