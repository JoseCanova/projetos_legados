package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.nanotek.NameBase;

@Entity
@Table(name="area")
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
	
	@Column(name="beginDateYear")
	private Integer beginDateYear; 
	@Column(name="beginDateMonth")
	private Integer beginDateMonth;
	@Column(name="beginDateDay")
	private Integer beginDateDay; 
	
	@Column(name="endDateYear")
	private Integer endDateYear; 
	@Column(name="endDateMonth")
	private Integer endDateMonth;
	@Column(name="endDateDay")
	private Integer endDateDay;
	
	@Column(name="comment" , length=1000 , insertable=true , updatable=true , nullable=true)
	private String comment;
	
	public Area() {}
	
	public Area(@NotNull Long id,@NotBlank @Size(min = 1, max = 1000) String name, @NotBlank @Size(min = 1, max = 50) String gid,
			@NotNull AreaType type, Integer beginDateYear, Integer beginDateMonth, Integer beginDateDay,
			Integer endDateYear, Integer endDateMonth, Integer endDateDay, String comment) {
		super(id);
		this.name = name;
		this.gid = gid;
		this.type = type;
		this.beginDateYear = beginDateYear;
		this.beginDateMonth = beginDateMonth;
		this.beginDateDay = beginDateDay;
		this.endDateYear = endDateYear;
		this.endDateMonth = endDateMonth;
		this.endDateDay = endDateDay;
		this.comment = comment;
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

	public Integer getBeginDateYear() {
		return beginDateYear;
	}

	public void setBeginDateYear(Integer beginDateYear) {
		this.beginDateYear = beginDateYear;
	}

	public Integer getBeginDateMonth() {
		return beginDateMonth;
	}

	public void setBeginDateMonth(Integer beginDateMonth) {
		this.beginDateMonth = beginDateMonth;
	}

	public Integer getBeginDateDay() {
		return beginDateDay;
	}

	public void setBeginDateDay(Integer beginDateDay) {
		this.beginDateDay = beginDateDay;
	}

	public Integer getEndDateYear() {
		return endDateYear;
	}

	public void setEndDateYear(Integer endDateYear) {
		this.endDateYear = endDateYear;
	}

	public Integer getEndDateMonth() {
		return endDateMonth;
	}

	public void setEndDateMonth(Integer endDateMonth) {
		this.endDateMonth = endDateMonth;
	}

	public Integer getEndDateDay() {
		return endDateDay;
	}

	public void setEndDateDay(Integer endDateDay) {
		this.endDateDay = endDateDay;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Area [name=" + name + ", gid=" + gid + ", type=" + type + ", beginDateYear=" + beginDateYear
				+ ", beginDateMonth=" + beginDateMonth + ", beginDateDay=" + beginDateDay + ", endDateYear="
				+ endDateYear + ", endDateMonth=" + endDateMonth + ", endDateDay=" + endDateDay + ", comment=" + comment
				+ ", id=" + id + "]";
	}

}
	
