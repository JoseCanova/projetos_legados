package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "AreaComment")
public class AreaComment extends CommentBase{

	private static final long serialVersionUID = 5715488911104999603L;

	@NotNull
	@OneToOne(mappedBy = "areaComment")
	private Area area;

	public AreaComment() {}
	
	public AreaComment(@NotBlank String comment) {
		super(comment);
	}

	public AreaComment(@NotBlank String comment,@NotNull Area area) {
		super(comment);
		this.area = area;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((area == null) ? 0 : area.hashCode());
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
		AreaComment other = (AreaComment) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AreaComment [area=" + area + ", comment=" + comment + ", id=" + id + "]";
	}
	
}
