package org.nanotek.beans.csv;

public class ReleaseGroupBean extends HolderBaseBean<ReleaseGroupBean,Long> {

	private static final long serialVersionUID = -1119657398190391884L;

	private Long id; 
	private String gid; 
	private String name; 
	private Long artistCredit; 
	private Long type;
	private String comment; 
	private String editsPending;
	private String lastUpdated;
	
	public ReleaseGroupBean() { 
		super();
	}
	
	
	@Override
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Override
	public String toString() {
		return "ReleaseGroupBean [id=" + id + ", gid=" + gid + ", name=" + name + ", artistCredit=" + artistCredit
				+ ", type=" + type + ", comment=" + comment + ", editsPending=" + editsPending + ", lastUpdated="
				+ lastUpdated + "]";
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

}
