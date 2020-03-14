package org.nanotek.beans.entity;

import java.util.function.Consumer;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="base_type",
					indexes= {
							@Index(unique = false , name = "base_type_id_idx" , columnList ="type_id")
						})
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
public abstract class BaseType extends TypeNamedEntity implements BaseTypeEntityBase<AreaType, Long> {

	private static final long serialVersionUID = -6795816207025448078L;

	@NotNull
	@Column(name="type_id" , nullable = false)
	protected Long typeId;
	
	@Column(name="parent")
	protected Long parent; 
	
	@Column(name="childOrder")
	protected Long childOrder;

	@OneToOne(optional=true,orphanRemoval = true)
	@JoinTable(
			  name = "base_type_description_join", 
			  joinColumns = @JoinColumn(name = "base_type_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "description_id",referencedColumnName = "id"))
	protected BaseTypeDescription description; 
	
	public BaseType() {
	}

	public BaseType(@NotNull Long typeId , @NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
		this.typeId = typeId;
	}
	
	public BaseType(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

	public BaseType(@NotNull String name) {
		super(name);
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
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

	public BaseTypeDescription getDescription() {
		return description;
	}

	public void setDescription(BaseTypeDescription description) {
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
