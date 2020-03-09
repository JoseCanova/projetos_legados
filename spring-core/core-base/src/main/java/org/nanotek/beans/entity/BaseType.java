package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseType extends LongIdGidNameEntity{

	private static final long serialVersionUID = 863905425134347710L;
	
	@Column(name="type_id")
	protected Long typeId;
	
	@Column(name="parent")
	protected Long parent; 
	
	@Column(name="childOrder")
	protected Long childOrder;

	@Column(name="description" , length=4000)
	protected String description; 
	
	public BaseType() {
	}

	public BaseType(Long id , String name, Long parent, Long childOrder, String description, String gid) {
		this.typeId = id;
		this.name = name;
		this.parent = parent;
		this.childOrder = childOrder;
		this.description = description;
		this.gid = gid;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Long getChildOrder() {
		return childOrder;
	}

	public void setChildOrder(Long childOrder) {
		this.childOrder = childOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BaseType other = (BaseType) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}

}
