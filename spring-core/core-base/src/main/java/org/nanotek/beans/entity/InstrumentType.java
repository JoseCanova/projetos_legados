package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="instrument_type")
public class InstrumentType extends EntityLongBase{

	
	private static final long serialVersionUID = 1526958848784766177L;

	@NotBlank
	@Size(min = 1 , max = 255)
	@Column(name="name" , length = 255 , nullable = false , insertable = true , updatable = true)
	private String name; 
	
	@Size(min = 1 , max = 4000)
	@Column(name="description" , length = 4000 , nullable = true , insertable = true , updatable = true)
	private String description; 
	
	@NotBlank
	@Size(min = 1 , max = 50)
	@Column(name="gid" , length = 50 , nullable = false , insertable = true , updatable = true)
	private String gid; 
	
	
	public InstrumentType() {
	}


	public InstrumentType(@NotNull Long id, @NotBlank @Size(min = 1, max = 255) String name,
			@Size(min = 1, max = 4000) String description, @NotBlank @Size(min = 1, max = 50) String gid) {
		super(id);
		this.name = name;
		this.description = description;
		this.gid = gid;
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
	public String toString() {
		return "InstrumentType [name=" + name + ", description=" + description + ", gid=" + gid + ", id=" + id + "]";
	}

}
