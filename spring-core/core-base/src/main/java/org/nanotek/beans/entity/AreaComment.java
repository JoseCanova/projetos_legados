package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.BaseEntity;
import org.nanotek.MutableCommentEntity;

@Entity
@DiscriminatorValue(value = "AreaComment")
public class AreaComment<E extends Serializable> extends CommentBase<String, AreaComment<E>> implements  MutableCommentEntity<String>,BaseEntity{

	private static final long serialVersionUID = -68821965634755841L;
	
	@NotNull
	@OneToOne(mappedBy = "areaComment")
	public Area<E> area;

	public AreaComment() {}
	
	public AreaComment(@NotBlank String comment) {
		super(comment);
	}

	public AreaComment(@NotBlank String comment,@NotNull Area<E> area) {
		super(comment);
		this.area = area;
	}

	public Area<E> getArea() {
		return area;
	}

	public void setArea(Area<E> area) {
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

	@Override
	public String getComment() {
		return comment;
	}
}
