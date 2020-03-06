package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.nanotek.NameBase;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseType extends EntityLongBase implements NameBase{

	private static final long serialVersionUID = 863905425134347710L;

	@Column(name="name" , insertable=true , nullable=false , length=255)
	protected String name; 
	
	@Column(name="parent")
	protected Long parent; 
	
	@Column(name="childOrder")
	protected Long childOrder;

	@Column(name="description" , length=4000)
	protected String description; 
	
	@Column (name="gid" , length=50 , nullable=false , insertable=true)
	protected String gid;
	
	public BaseType() {
	}

	public BaseType(Long id , String name, Long parent, Long childOrder, String description, String gid) {
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
