package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nanotek.Base;

@Entity
@Table(name="release_group")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReleaseGroup extends EntityLongBase{

	private static final long serialVersionUID = 7603390865547084527L;
	
	@NotBlank
	@Column (name="gid" , length=50 , nullable=false)
	private String gid; 
	@NotBlank
	@Column (name="name" , length=2500 , nullable=false)
	private String name; 
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name="artist_credit_id")
	private ArtistCredit artistCredit; 
	
	@ManyToOne(fetch = FetchType.LAZY , optional = true)
	@JoinColumn(name = "type_id")
	private ReleaseGroupPrimaryType type;
	
	public ReleaseGroup() {}
	
	public ReleaseGroup(@NotNull Long id, @NotBlank String gid, @NotBlank String name, @NotNull ArtistCredit artistCredit,
			ReleaseGroupPrimaryType type) {
		super(id);
		this.gid = gid;
		this.name = name;
		this.artistCredit = artistCredit;
		this.type = type;
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
	
	public ArtistCredit getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(ArtistCredit artistCredit) {
		this.artistCredit = artistCredit;
	}

	public ReleaseGroupPrimaryType getType() {
		return type;
	}

	public void setType(ReleaseGroupPrimaryType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReleaseGroup other = (ReleaseGroup) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReleaseGroup [gid=" + gid + ", name=" + name + ", artistCredit=" + artistCredit + ", type=" + type
				+ ", id=" + id + "]";
	} 
	
}
