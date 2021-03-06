package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@MappedSuperclass
public class LongIdGidNameEntity extends LongIdNameEntity {

	private static final long serialVersionUID = -3230710199273457686L;
	
	
	@NotBlank
	@Length(min = 1 , max = 50)
	@Column(name="gid", nullable=false)
	protected String gid;

	
	public LongIdGidNameEntity() {
		super();
	}

	public LongIdGidNameEntity(@NotNull String name) {
		super(name);
	}

	public LongIdGidNameEntity(
								@NotBlank @Length(min = 1, max = 50) String gid, 
								@NotNull String name) {
		super(name);
		this.gid = gid;
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
		LongIdGidNameEntity other = (LongIdGidNameEntity) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		return true;
	}
	
}
