package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="release_packaging")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReleasePackaging extends EntityLongBase{

	private static final long serialVersionUID = 5351338443793025420L;

	@Column(name="name" , length=255 , nullable=false , insertable=true , updatable=true)
	private String name; 
	
	@Column(name="gid" , length=50 , nullable=false , insertable=true , updatable=true)
	private String gid;
	
	public ReleasePackaging() {}

	public ReleasePackaging(Long id, String name, String gid) {
		super(id);
		this.name = name;
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
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
		ReleasePackaging other = (ReleasePackaging) obj;
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
		return "ReleasePackaging [name=" + name + ", gid=" + gid + ", id=" + id + "]";
	}
	
}
