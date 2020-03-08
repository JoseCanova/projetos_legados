package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="release_group")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReleaseGroup extends LongIdGidNameEntity{

	private static final long serialVersionUID = 7603390865547084527L;
	
	@NotNull
	@Column(name="release_group_id" , nullable=false)
	private Long releaseGroupId;
	
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
		super(gid,name);
		this.artistCredit = artistCredit;
		this.type = type;
		this.releaseGroupId = id;
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

	public Long getReleaseGroupId() {
		return releaseGroupId;
	}

	public void setReleaseGroupId(Long releaseGroupId) {
		this.releaseGroupId = releaseGroupId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((releaseGroupId == null) ? 0 : releaseGroupId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (releaseGroupId == null) {
			if (other.releaseGroupId != null)
				return false;
		} else if (!releaseGroupId.equals(other.releaseGroupId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReleaseGroup [releaseGroupId=" + releaseGroupId + ", artistCredit=" + artistCredit + ", type=" + type
				+ ", gid=" + gid + ", name=" + name + ", id=" + id + "]";
	}

	
	
}
