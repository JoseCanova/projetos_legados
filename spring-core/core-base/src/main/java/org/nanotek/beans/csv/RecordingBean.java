package org.nanotek.beans.csv;

import org.nanotek.Base;

public class RecordingBean  implements Base<Long>{

	private static final long serialVersionUID = 2926594064752891481L;
	
	private Long id;
    private String gid;
    private String name;
    private Long artistCredit;
    private Long length;
    private String comment;
    private Long editsPending;
    private String lastUpdated;
    private String  video;
    
    public RecordingBean() {}

	public Long getId() {
		return id;
	}

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

	public Long getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getEditsPending() {
		return editsPending;
	}

	public void setEditsPending(Long editsPending) {
		this.editsPending = editsPending;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
