package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@MappedSuperclass
@DiscriminatorValue(value = "BaseType")
public class TypeNamedEntity extends LongIdGidNameEntity {

	private static final long serialVersionUID = -3301662218058508511L;

	public TypeNamedEntity() {
	}

	public TypeNamedEntity(@NotNull String name) {
		super(name);
	}

	public TypeNamedEntity(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

}
