package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseType extends EntityLongBase {

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
	
	
	

}
