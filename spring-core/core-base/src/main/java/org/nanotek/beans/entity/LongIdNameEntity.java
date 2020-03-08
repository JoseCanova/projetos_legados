package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import org.nanotek.MutableName;
import org.nanotek.NameBase;

@MappedSuperclass
public class LongIdNameEntity extends SequenceLongBase implements NameBase , MutableName{

	private static final long serialVersionUID = -3442197714885490996L;

	@NotBlank
	@Column(name="name" , nullable=false, columnDefinition = "VARCHAR NOT NULL")
	protected String name;
	
	public LongIdNameEntity() {
		super();
	}

	public LongIdNameEntity(@NotBlank String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		LongIdNameEntity other = (LongIdNameEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "LongIdNameEntity [name=" + name + ", id=" + id + "]";
	}

}
