package org.nanotek.beans.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class RecordingAliasType extends BaseType {

	private static final long serialVersionUID = -1922272725479730994L;
	
	public RecordingAliasType() {
	}
	
	public RecordingAliasType(@NotBlank @Length(min = 1, max = 50) String gid, @NotNull String name) {
		super(gid, name);
	}

	public RecordingAliasType(@NotNull String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "RecordingAliasType [name=" + name + ", parent=" + parent + ", childOrder=" + childOrder
				+ ", description=" + description + ", gid=" + gid + ", id=" + id + "]";
	}

	@Override
	public String getGid() {
		// TODO Auto-generated method stub
		return gid;
	}

	@Override
	public String getName() {
		return name;
	}
	
}
