package org.nanotek.beans;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.nanotek.LongBase;

@SuppressWarnings("serial")
@MappedSuperclass
public class EntityLongBase implements LongBase {

	@Id
	@NotNull
	@Column(name="id",nullable=false,unique=true)
	protected Long id;
	
	public EntityLongBase() {
	}
	
	public EntityLongBase(@NotNull Long id) {
		super();
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EntityLongBase other = (EntityLongBase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
