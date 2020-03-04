package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="area_type")
public class AreaType extends EntityLongBase {

	private static final long serialVersionUID = 5334032717060542549L;
	
	@Column(name="name" , insertable=true , nullable=false , length=255)
	private String name; 
	
	@Column(name="parent")
	private Long parent; 
	
	@Column(name="childOrder")
	private Long childOrder;

	@Column(name="description" , length=4000)
	private String description; 
	
	@Column (name="gid" , length=50 , nullable=false , insertable=true)
	private String gid;
	
	public AreaType() {
	}

	public AreaType(Long id, String name, Long parent, Long childOrder, String description, String gid) {
		super(id);
		this.name = name;
		this.parent = parent;
		this.childOrder = childOrder;
		this.description = description;
		this.gid = gid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
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
		AreaType other = (AreaType) obj;
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
		return "AreaType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder + ", description="
				+ description + ", gid=" + gid + ", id=" + id + "]";
	}
	
}
