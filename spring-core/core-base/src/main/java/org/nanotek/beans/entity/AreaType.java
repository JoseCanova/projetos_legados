package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.nanotek.TypeBase;

@Entity
@DiscriminatorValue(value = "AreaType")
public class AreaType extends BaseType  {

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

	@Override
	public String getGid() {
		return gid;
	}

	@Override
	public String getName() {
		return name;
	}
	
}
