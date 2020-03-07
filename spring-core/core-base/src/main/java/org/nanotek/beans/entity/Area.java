package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nanotek.NameBase;

@Entity
@Table(name="area")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE , region = "org.nanotek.beans.entity.Area")
public class Area extends EntityLongBase implements NameBase{

	private static final long serialVersionUID = -7073321340141567106L;
	
	@NotBlank
	@Size(min=1,max=1000)
	@Column(name="name" , length=1000 , insertable=true , updatable=true , nullable=false)
	private String name; 
	
	@NotBlank
	@Size(min=1,max=50)
	@Column(name="gid" , length=50 , insertable=true , updatable=true , nullable=false)
	private String gid;
	
	@NotNull
	@ManyToOne(optional=false, fetch = FetchType.LAZY )
	private AreaType type; 
	
	@OneToOne
	@JoinTable(
			  name = "area_begin_date_join", 
			  joinColumns = @JoinColumn(name = "area_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private AreaBeginDate areaBeginDate; 
	
	@OneToOne
	@JoinTable(
			  name = "area_end_date_join", 
			  joinColumns = @JoinColumn(name = "area_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "date_id",referencedColumnName = "id") )
	private AreaEndDate areaEndDate;
	

	@OneToOne(mappedBy = "area")
	private AreaComment areaComment;
	
	public Area() {}
	
	public Area(@NotNull Long id, @NotBlank @Size(min = 1, max = 1000) String name, @NotBlank @Size(min = 1, max = 50) String gid) {
		super(id);
		this.name = name;
		this.gid = gid;
	}

	public Area(@NotNull Long id, 
			@NotBlank @Size(min = 1, max = 1000) String name, @NotBlank @Size(min = 1, max = 50) String gid,
			@NotNull AreaType type, AreaBeginDate areaBeginDate, AreaEndDate areaEndDate, AreaComment areaComment) {
		super(id);
		this.name = name;
		this.gid = gid;
		this.type = type;
		this.areaBeginDate = areaBeginDate;
		this.areaEndDate = areaEndDate;
		this.areaComment = areaComment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AreaType getType() {
		return type;
	}

	public void setType(AreaType type) {
		this.type = type;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public AreaBeginDate getAreaBeginDate() {
		return areaBeginDate;
	}

	public void setAreaBeginDate(AreaBeginDate areaBeginDate) {
		this.areaBeginDate = areaBeginDate;
	}

	public AreaEndDate getAreaEndDate() {
		return areaEndDate;
	}

	public void setAreaEndDate(AreaEndDate areaEndDate) {
		this.areaEndDate = areaEndDate;
	}

	public AreaComment getAreaComment() {
		return areaComment;
	}

	public void setAreaComment(AreaComment areaComment) {
		this.areaComment = areaComment;
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
		Area other = (Area) obj;
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
		return "Area [name=" + name + ", gid=" + gid + ", type=" + type + ", areaBeginDate=" + areaBeginDate
				+ ", areaEndDate=" + areaEndDate + ", areaComment=" + areaComment + ", id=" + id + "]";
	}
	
}