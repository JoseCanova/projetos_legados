package org.nanotek.beans.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="gender")
public class Gender extends BaseType{

	private static final long serialVersionUID = 1628032460585953186L;

	public Gender() {
	}

	public Gender(Long id, String name, Long parent, Long childOrder, String description, String gid) {
		super(id, name, parent, childOrder, description, gid);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Gender [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}

}
