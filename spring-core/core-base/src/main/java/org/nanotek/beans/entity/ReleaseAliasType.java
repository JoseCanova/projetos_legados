package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="release_alias_type")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE , region = "org.nanotek.beans.entity.ReleaseAliasType")
public class ReleaseAliasType extends BaseType {

	private static final long serialVersionUID = 6615127464602860751L;

	public ReleaseAliasType() {
	}

	public ReleaseAliasType(Long id, String name, Long parent, Long childOrder, String description, String gid) {
		super(id, name, parent, childOrder, description, gid);
	}

	@Override
	public String toString() {
		return "ReleaseAliasType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}

}
