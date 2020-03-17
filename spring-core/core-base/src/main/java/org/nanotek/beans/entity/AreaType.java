package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.nanotek.MutableAreaEntity;

@Entity
@DiscriminatorValue(value = "AreaType")
public class AreaType extends BaseType<Area> implements MutableAreaEntity<Area> {

	private static final long serialVersionUID = 5334032717060542549L;
	
	@OneToOne
	private Area area;
	
	public AreaType() {
	}

	public AreaType(@NotBlank @Length(min = 1, max = 50) String gid, @NotBlank String name) {
		super(gid, name);
	}

	public AreaType(@NotBlank String name) {
		super(name);
	}

	@Override
	public Area getArea() {
		return area;
	}

	@Override
	public void setArea(Area k) {
			this.area = k;
	}

}
