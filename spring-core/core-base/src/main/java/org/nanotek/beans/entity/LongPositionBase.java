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
@Table(name="long_position_base",
indexes= {
		@Index(unique = false , name = "long_position_position_idx" , columnList ="position"),
		@Index(unique = false , name = "long_position_table_idx" , columnList ="table_id")
	})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
public class LongPositionBase extends PositionEntityBase<Long> {

	private static final long serialVersionUID = 2610811597922933992L;

	@NotNull
	@Column(name="position" , nullable=false)
	protected Long position;
	
	public LongPositionBase() {
	}

	public LongPositionBase(@NotNull Long position) {
		super();
		this.position = position;
	}

	@Override
	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		LongPositionBase other = (LongPositionBase) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LongPositionBase [position=" + position + ", id=" + id + "]";
	}
}
