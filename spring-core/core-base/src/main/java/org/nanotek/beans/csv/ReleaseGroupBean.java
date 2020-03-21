package org.nanotek.beans.csv;

import org.nanotek.ImmutableBase;
import org.nanotek.beans.entity.ReleaseGroup;

public class ReleaseGroupBean 
<K extends ReleaseGroupBean<K,ID>,ID extends ReleaseGroup<ID>> 
implements ImmutableBase<K , ID>,BaseBean<K>{

	private static final long serialVersionUID = -1119657398190391884L;

	private ID id; 
	
	public ID getId() { 
		return id;
	}
	
	public Long releaseGroupId; 
	public String gid; 
	public String name; 
	public Long artistCredit; 
	public Long type;
	public String comment; 
	public String editsPending;
	public String lastUpdated;
	
	public ReleaseGroupBean(ID id) {
		super();
		this.id = id;
	}


	public ReleaseGroupBean() { 
		super();
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

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getReleaseGroupId() {
		return releaseGroupId;
	}

	public void setReleaseGroupId(Long releaseGroupId) {
		this.releaseGroupId = releaseGroupId;
	}

}
