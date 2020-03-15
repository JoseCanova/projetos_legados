package org.nanotek.beans.csv;

public class MediumBean extends  HolderBaseBean<MediumBean,Long>{

	private static final long serialVersionUID = -8141072962299778762L;

	private Long id;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "MediumBean [id=" + id + ", release=" + release + ", position=" + position + ", format=" + format
				+ ", name=" + name + ", editsPending=" + editsPending + ", lastUpdated=" + lastUpdated + ", trackCount="
				+ trackCount + "]";
	}
	
}
