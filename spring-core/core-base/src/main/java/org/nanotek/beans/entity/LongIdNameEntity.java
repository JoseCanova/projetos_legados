package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.nanotek.NameBase;

@MappedSuperclass
public class LongIdNameEntity extends EntityLongBase implements NameBase{

	private static final long serialVersionUID = -3442197714885490996L;

	@NotNull
	@Column(name="name" , nullable=false, columnDefinition = "VARCHAR NOT NULL")
	protected String name;
	
	public LongIdNameEntity() {
	}

	public LongIdNameEntity(@NotNull Long id) {
		super(id);
	}

	public LongIdNameEntity(@NotNull Long id , @NotNull String name) {
		super(id);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
