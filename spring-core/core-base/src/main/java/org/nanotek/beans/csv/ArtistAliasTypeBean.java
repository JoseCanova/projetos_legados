package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.ArtistAliasType;

public class ArtistAliasTypeBean extends Result<ArtistAliasTypeBean,ArtistAliasType<ArtistAliasTypeBean>> {

	private static final long serialVersionUID = 901207660901713562L;
	
	private Long artistAliasTypeId; 
	private String name; 
	private Long parent; 
	private Long childOrder; 
	private String description; 
	private String gid;
	
	public ArtistAliasTypeBean() {
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Long getChildOrder() {
		return childOrder;
	}

	public void setChildOrder(Long childOrder) {
		this.childOrder = childOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}


	public Long getArtistAliasTypeId() {
		return artistAliasTypeId;
	}


	public void setArtistAliasTypeId(Long artistAliasTypeId) {
		this.artistAliasTypeId = artistAliasTypeId;
	}
}
