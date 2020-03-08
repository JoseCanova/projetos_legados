package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nanotek.NameBase;

@Entity
@Table(name="medium_format")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MediumFormat extends EntityLongBase implements NameBase{

	private static final long serialVersionUID = 8104913204474210789L;
	
	@NotBlank
	@Size(min=1,max=100)
	@Column(name = "name" , length=100 , insertable=true , nullable=false , updatable=true)
	private String name; 
	
	@Column(name = "parent")
	private Long parent;
	
	@Column(name = "year")
	private Integer year; 
	
	@Column(name = "hasDiscId", length=6, nullable=false)
	private String hasDiscId;
	
	@NotBlank
	@Column(name = "gid" , length=50 , insertable=true , nullable=false , updatable=true)
	private String gid;
	
	@Column(name="description" , length=4000)
	private String description;
	
	public MediumFormat() { 
		super();
	}
	
	public MediumFormat(@NotNull Long id , 
			@NotBlank @Size(min = 1, max = 100) String name, 
			Long parent, Integer year, String hasDiscId,
			@NotBlank String gid, String description) {
		super(id);
		this.name = name;
		this.parent = parent;
		this.year = year;
		this.hasDiscId = hasDiscId;
		this.gid = gid;
		this.description = description;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getHasDiscId() {
		return hasDiscId;
	}

	public void setHasDiscId(String hasDiscId) {
		this.hasDiscId = hasDiscId;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
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
		MediumFormat other = (MediumFormat) obj;
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
		return "MediumFormat [name=" + name + ", parent=" + parent + ", year=" + year + ", hasDiscId=" + hasDiscId
				+ ", gid=" + gid + ", description=" + description + ", id=" + id + "]";
	}
	
}