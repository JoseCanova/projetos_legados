package org.nanotek.beans.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@MappedSuperclass
public abstract class TypeNamedEntity extends LongIdGidNameEntity {

	public TypeNamedEntity() {
	}

	public TypeNamedEntity(@NotNull String name) {
		super(name);
	}

	public TypeNamedEntity(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

}
