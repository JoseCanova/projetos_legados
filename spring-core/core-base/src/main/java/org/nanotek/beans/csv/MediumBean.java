package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.Medium;

public class MediumBean extends  Result<MediumBean,Medium>{

	private static final long serialVersionUID = -8141072962299778762L;

	private Long mediumId;
	
	private Long release; 
	
	private Long position;
	
	private Long format; 
	
	private String name; 
	
	private String editsPending; 
	
	private String lastUpdated; 
	
	private Integer trackCount; 
	
	public MediumBean() {
		super();
	}

	public Long getRelease() {
		return release;
	}

	public void setRelease(Long release) {
		this.release = release;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getFormat() {
		return format;
	}

	public void setFormat(Long format) {
		this.format = format;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditsPending() {
		return editsPending;
	}

	public void setEditsPending(String editsPending) {
		this.editsPending = editsPending;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}

	public Long getMediumId() {
		return mediumId;
	}

	public void setMediumId(Long mediumId) {
		this.mediumId = mediumId;
	}
	
}
