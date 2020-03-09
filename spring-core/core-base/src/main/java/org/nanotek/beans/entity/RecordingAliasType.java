package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

@Entity
@DiscriminatorValue(value="RecordingAliasType")
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
	
}
