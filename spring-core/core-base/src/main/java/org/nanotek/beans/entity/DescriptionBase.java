package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="description_base")
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR(2)"
	)
public class DescriptionBase extends SequenceLongBase{

	private static final long serialVersionUID = -4976009864905272762L;

	@NotNull
	@Column(name="description", columnDefinition = "VARCHAR NOT NULL" , nullable=false)
	private String description;
	
	public DescriptionBase() {
	}

	public DescriptionBase(@NotNull String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		DescriptionBase other = (DescriptionBase) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DescriptionBase [description=" + description + ", id=" + id + "]";
	}


}
