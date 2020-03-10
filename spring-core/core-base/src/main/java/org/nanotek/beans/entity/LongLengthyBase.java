package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="long_lengthy_base",
						indexes= {
								@Index(unique = false , name = "long_length_table_idx" , columnList ="table_id")
							})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
public class LongLengthyBase extends LengthyBase<Long>{

	private static final long serialVersionUID = -8797268785342768025L;
	
	@NotNull
	@Column(name="length" , nullable=false)
	protected  Long length;
	
	public LongLengthyBase() {
	}

	public LongLengthyBase(@NotNull Long length) {
		super();
		this.length = length;
	}

	@Override
	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
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
