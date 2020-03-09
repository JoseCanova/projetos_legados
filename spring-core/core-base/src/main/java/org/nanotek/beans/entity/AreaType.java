package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

@Entity
@DiscriminatorValue(value = "AreaType")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AreaType extends BaseType {

	private static final long serialVersionUID = 5334032717060542549L;
	
	public AreaType() {
	}

	public AreaType(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

	public AreaType(@NotBlank String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "AreaType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}
	
}
