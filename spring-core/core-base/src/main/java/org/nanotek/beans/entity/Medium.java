package org.nanotek.beans.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="medium")
public class Medium extends LongIdNameEntity{

	private static final long serialVersionUID = 6669274101742169443L;

	@NotNull
	@OneToOne(optional=false)
	@JoinTable(
			  name = "medium_count_join", 
			  joinColumns = @JoinColumn(name = "medium_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "position_id",referencedColumnName = "id"))
	private MediumCount trackCount; 

	@NotNull
	@OneToOne
	@JoinTable(
			  name = "medium_position_join", 
			  joinColumns = @JoinColumn(name = "medium_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "position_id",referencedColumnName = "id"))
	private MediumPosition position;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name="release_id")
	private Release release;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="medium_format_id")
	private MediumFormat format;

	public Medium() {}

	
	public Medium(@NotBlank String name) {
		super(name);
	}

	public MediumCount getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(MediumCount trackCount) {
		this.trackCount = trackCount;
	}

	public MediumPosition getPosition() {
		return position;
	}

	public void setPosition(MediumPosition position) {
		this.position = position;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((release == null) ? 0 : release.hashCode());
		result = prime * result + ((trackCount == null) ? 0 : trackCount.hashCode());
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
		Medium other = (Medium) obj;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		if (trackCount == null) {
			if (other.trackCount != null)
				return false;
		} else if (!trackCount.equals(other.trackCount))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Medium [trackCount=" + trackCount + ", position=" + position + ", release=" + release + ", format="
				+ format + ", name=" + name + ", id=" + id + "]";
	}

}
