package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="area" , 
uniqueConstraints= {
		@UniqueConstraint(name="uk_area_gid",columnNames={"gid"}),
		@UniqueConstraint(name="uk_area_id",columnNames={"area_id"})
		},
		indexes= {
					@Index(unique = false , name = "artist_name_idx" , columnList ="name")
				})
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE , region = "org.nanotek.beans.entity.Area")
public class Area extends LongIdGidNameEntity{

	private static final long serialVersionUID = -7073321340141567106L;
	
	@NotNull
	@Column(name="area_id",nullable=false)
	private Long areaId; 
	
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
	

	@OneToOne
	@JoinTable(
			  name = "area_comment_join", 
			  joinColumns = @JoinColumn(name = "area_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "comment_id",referencedColumnName = "id") )
	private AreaComment areaComment;
	
	public Area() {}
	
	public Area(@NotNull Long id, @NotBlank String name, @NotBlank  String gid) {
		this.name = name;
		this.gid = gid;
		this.areaId = id;
	}

	public Area(@NotNull Long id, 
			@NotBlank String name, @NotBlank  String gid,
			@NotNull AreaType type, AreaBeginDate areaBeginDate, AreaEndDate areaEndDate, AreaComment areaComment) {
		this.name = name;
		this.gid = gid;
		this.type = type;
		this.areaBeginDate = areaBeginDate;
		this.areaEndDate = areaEndDate;
		this.areaComment = areaComment;
		this.areaId = id;
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

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((areaId == null) ? 0 : areaId.hashCode());
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
		if (areaId == null) {
			if (other.areaId != null)
				return false;
		} else if (!areaId.equals(other.areaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", type=" + type + ", areaBeginDate=" + areaBeginDate + ", areaEndDate="
				+ areaEndDate + ", areaComment=" + areaComment + ", gid=" + gid + ", name=" + name + ", id=" + id + "]";
	}

	
}