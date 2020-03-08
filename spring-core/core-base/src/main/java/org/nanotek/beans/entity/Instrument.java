package org.nanotek.beans.entity;

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

import org.nanotek.MutableName;

@Entity
@Table(name="instrument")
public class Instrument extends LongIdNameEntity implements MutableName{

	private static final long serialVersionUID = 1720965406197902687L;

	@NotBlank
	@Size(min=1,max=50)
	@Column(name="gid" , length=50 , nullable=false,insertable=true,updatable=true)
	private String gid;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY , optional = false )
	private InstrumentType type; 
	
	@OneToOne(optional=true)
	@JoinTable(
			  name = "instrument_comment_join", 
			  joinColumns = @JoinColumn(name = "instrument_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "comment_id",referencedColumnName = "id"))
	private InstrumentComment comment;
	
	@OneToOne(optional=true)
	@JoinTable(
			  name = "description_comment_join", 
			  joinColumns = @JoinColumn(name = "instrument_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "description_id",referencedColumnName = "id"))
	private InstrumentDescription description;
	
	public Instrument() {
	}
	
	public Instrument(  @NotNull Long id,  
						@NotBlank @Size(min = 1, max = 50) String gid, 
						@NotBlank String name,
						@NotNull InstrumentType type) {
		super(id);
		this.gid = gid;
		this.name = name;
		this.type = type;
	}

	public Instrument(
						@NotNull Long id, 
						@NotBlank @Size(min = 1, max = 50) String gid, 
						@NotBlank String name,
						@NotNull InstrumentType type, 
						InstrumentComment comment, 
						InstrumentDescription description) {
		super(id);
		this.gid = gid;
		this.name = name;
		this.type = type;
		this.comment = comment;
		this.description = description;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public InstrumentComment getComment() {
		return comment;
	}

	public void setComment(InstrumentComment comment) {
		this.comment = comment;
	}

	public InstrumentDescription getDescription() {
		return description;
	}

	public void setDescription(InstrumentDescription description) {
		this.description = description;
	}

	public InstrumentType getType() {
		return type;
	}

	public void setType(InstrumentType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Instrument [gid=" + gid + ", name=" + name + ", type=" + type + ", comment=" + comment
				+ ", description=" + description + ", id=" + id + "]";
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
		Instrument other = (Instrument) obj;
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

}
