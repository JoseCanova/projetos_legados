package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="release_packaging")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReleasePackaging extends LongIdGidNameEntity{

	private static final long serialVersionUID = 5351338443793025420L;

	private Long releasePackagingId;
	
	public ReleasePackaging() {}

	public ReleasePackaging(Long id, String name, String gid) {
		super(gid,name);
		this.releasePackagingId = id;
	}

	public Long getReleasePackagingId() {
		return releasePackagingId;
	}

	public void setReleasePackagingId(Long releasePackagingId) {
		this.releasePackagingId = releasePackagingId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((releasePackagingId == null) ? 0 : releasePackagingId.hashCode());
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
		ReleasePackaging other = (ReleasePackaging) obj;
		if (releasePackagingId == null) {
			if (other.releasePackagingId != null)
				return false;
		} else if (!releasePackagingId.equals(other.releasePackagingId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReleasePackaging [releasePackagingId=" + releasePackagingId + ", gid=" + gid + ", name=" + name
				+ ", id=" + id + "]";
	}

}
