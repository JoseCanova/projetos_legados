package org.nanotek.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="artist_key")
public class ArtistKey implements Base<String>{
	
	private String id;
	private Long key;
	private String gid; 
	private Long nameId; 
	private Long sortNameId;
	private Long typeId; 
	private Long genderId;
	private Long countryId;
	
	
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public Long getNameId() {
		return nameId;
	}
	public void setNameId(Long nameId) {
		this.nameId = nameId;
	}
	public Long getSortNameId() {
		return sortNameId;
	}
	public void setSortNameId(Long sortNameId) {
		this.sortNameId = sortNameId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getGenderId() {
		return genderId;
	}
	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
}
