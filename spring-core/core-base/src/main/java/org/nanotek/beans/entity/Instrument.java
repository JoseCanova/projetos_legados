package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="instrument")
public class Instrument extends EntityLongBase {

	private static final long serialVersionUID = 1720965406197902687L;

	@NotBlank
	@Size(min=1,max=50)
	@Column(name="gid" , length=50 , nullable=false,insertable=true,updatable=true)
	private String gid;
	
	@NotBlank
	@Size(min=1,max=255)
	@Column(name="name" , length=255 , nullable=false , insertable=true , updatable=true)
	private String name; 
	
	@ManyToOne(fetch = FetchType.LAZY , optional = false )
	private InstrumentType type; 
	
	@Column(name="comment" , length=255 , nullable=true , insertable=true, updatable=true)
	private String comment; 
	
	@Column(name="description" , length=4000 , nullable=true , insertable=true , updatable=true)
	private String description;
	
	public Instrument() {
	}
	
	public Instrument(@NotNull Long id, @NotBlank @Size(min = 1, max = 50) String gid, @NotBlank @Size(min = 1, max = 255) String name,
			InstrumentType type, String comment, String description) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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
