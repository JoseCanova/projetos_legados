package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="recording_alias_type")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RecordingAliasType extends BaseType {

	private static final long serialVersionUID = -1922272725479730994L;
	
	public RecordingAliasType() {
	}

	public RecordingAliasType(Long id, String name, Long parent, Long childOrder, String description, String gid) {
		super(id, name, parent, childOrder, description, gid);
	}

	@Override
	public String toString() {
		return "RecordingAliasType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder
				+ ", description=" + description + ", gid=" + gid + ", id=" + id + "]";
	}
	
}
