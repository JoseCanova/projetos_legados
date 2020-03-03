package org.nanotek.beans.csv;

import org.nanotek.LongBase;

public class ReleaseGroupBean implements LongBase {

	/**
	 * id                  SERIAL,
    gid                 UUID NOT NULL,
    name                VARCHAR NOT NULL,
    artist_credit       INTEGER NOT NULL, -- references artist_credit.id
    type                INTEGER, -- references release_group_primary_type.id
    comment             VARCHAR(255) NOT NULL DEFAULT '',
    edits_pending       INTEGER NOT NULL DEFAULT 0 CHECK (edits_pending >= 0),
    last_updated        TIMESTAMP WITH TIME ZONE DEFAULT NOW()
	 */
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
