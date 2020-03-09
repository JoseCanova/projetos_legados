package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

@Entity
@DiscriminatorValue(value="ReleaseAliasType")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE , region = "org.nanotek.beans.entity.ReleaseAliasType")
public class ReleaseAliasType extends BaseType {

	private static final long serialVersionUID = 6615127464602860751L;

	public ReleaseAliasType() {
	}

	public ReleaseAliasType(@NotBlank @Length(min = 1, max = 50) String gid, @NotNull String name) {
		super(gid, name);
	}

	public ReleaseAliasType(@NotNull String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "ReleaseAliasType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}

}
