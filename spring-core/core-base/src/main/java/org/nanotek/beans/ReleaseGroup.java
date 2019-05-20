package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="RELEASE_GROUP")
public class ReleaseGroup implements Base<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="release_group_seq")
	@SequenceGenerator(name="release_group_seq",sequenceName="release_group_id_seq")
	private Long id; 
	@Column(name="RELEASE_GROUP_ID" , nullable=false)
	private Long releaseGroupId; 
	@Column (name="GID" , length=255 , nullable=true)
	private String gid; 
	@Column (name="NAME" , length=2500 , nullable=true)
	private String name; 
	@Column(name="ARTIST_CREDIT" , nullable=true)
	private Long artistCredit; 
	@Column(name="TYPE" , nullable=true)
	private Integer type;
	
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
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	} 
	
	public Long getReleaseGroupId() {
		return releaseGroupId;
	}

	public void setReleaseGroupId(Long releaseGroupId) {
		this.releaseGroupId = releaseGroupId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((releaseGroupId == null) ? 0 : releaseGroupId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReleaseGroup other = (ReleaseGroup) obj;
		if (releaseGroupId == null) {
			if (other.releaseGroupId != null)
				return false;
		} else if (!releaseGroupId.equals(other.releaseGroupId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReleaseGroup [id=" + id + ", releaseGroupId=" + releaseGroupId
				+ ", gid=" + gid + ", name=" + name + ", artistCredit="
				+ artistCredit + ", type=" + type + "]";
	}
}
