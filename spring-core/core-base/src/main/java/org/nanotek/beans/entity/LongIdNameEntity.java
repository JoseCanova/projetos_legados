package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nanotek.MutableName;
import org.nanotek.NameBase;

@Entity
@Table(name="long_id_name",
		indexes= {
					@Index(unique = false , name = "name_idx" , columnList ="name")
				})
@Inheritance(strategy = InheritanceType.JOINED)
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class LongIdNameEntity extends SequenceLongBase implements NameBase<String>{

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
