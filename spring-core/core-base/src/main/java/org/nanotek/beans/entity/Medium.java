package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="medium")
public class Medium extends LongIdNameEntity{

	private static final long serialVersionUID = 6669274101742169443L;

	@Column(name="track_count")
	private Long trackCount; 

	@NotNull
	@Column(name="position",nullable=true)
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
	

	
	public Long getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(Long trackCount) {
		this.trackCount = trackCount;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

}
