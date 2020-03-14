package org.nanotek.beans.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;


@MappedSuperclass
public abstract class LongLengthyBase extends LengthyBase<Long>{

	public LongLengthyBase() {
	}

	public LongLengthyBase(@NotNull Long length) {
		super();
		this.length = length;
	}

	public Long getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LongLengthyBase other = (LongLengthyBase) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LongLengthyBase [length=" + length + ", id=" + id + "]";
	}

}
