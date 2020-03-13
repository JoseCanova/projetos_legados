package org.nanotek.beans.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nanotek.BaseDescriptionBase;

@Entity
@Table(name="description_base",
						indexes= {
								@Index(unique = false , name = "description_table_idx" , columnList ="description"),
								@Index(unique = false , name = "description_table_id_idx" , columnList ="table_id")
							})
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
@Cacheable(value = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DescriptionBase extends SequenceLongBase implements BaseDescriptionBase<Long , String>{

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
