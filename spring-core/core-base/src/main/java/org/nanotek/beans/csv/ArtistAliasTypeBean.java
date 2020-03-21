package org.nanotek.beans.csv;

import org.nanotek.ImmutableBase;
import org.nanotek.beans.entity.ArtistAliasType;

public class ArtistAliasTypeBean<K extends ArtistAliasTypeBean<K,ID>, ID extends ArtistAliasType<ID,?>> 
implements ImmutableBase<K,ID> ,BaseBean<K>{

	private static final long serialVersionUID = 901207660901713562L;
	
	private ID id;
	
	public ID getId() { 
		return id;
	}
	
	public Long artistAliasTypeId; 
	public String name; 
	public Long parent; 
	public Long childOrder; 
	public String description; 
	public String gid;
	
	public ArtistAliasTypeBean() {
	}

	public ArtistAliasTypeBean(ID id) {
		super();
		this.id = id;
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
