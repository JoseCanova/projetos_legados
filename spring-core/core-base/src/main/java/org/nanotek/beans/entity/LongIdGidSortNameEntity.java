package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@MappedSuperclass
public class LongIdGidSortNameEntity extends LongIdSortNameEntity {

	private static final long serialVersionUID = 3477844748693760556L;

	@NotBlank
	@Length(min = 1 , max = 50)
	@Column(name="gid", nullable=false)
	protected String gid;
	
	public LongIdGidSortNameEntity() {
		super();
	}

	public LongIdGidSortNameEntity(@NotNull String name, @NotNull String sortName , @NotNull String gid) {
		super(name, sortName);
		this.gid = gid;
	}
	
	public LongIdGidSortNameEntity( @NotNull String name, @NotNull String sortName) {
		super(name, sortName);
	}

	public LongIdGidSortNameEntity(@NotNull String name) {
		super(name);
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
		LongIdGidSortNameEntity other = (LongIdGidSortNameEntity) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LongIdGidSortNameEntity [gid=" + gid + ", sortName=" + sortName + ", name=" + name + ", id=" + id + "]";
	}
	
	
	
}
