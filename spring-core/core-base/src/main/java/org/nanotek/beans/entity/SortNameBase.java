package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.nanotek.SortBase;

@Entity
@Table(name="sort_name_base",
							indexes= {
									@Index(unique = false , name = "long_count_table_idx" , columnList ="table_id")
								})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
public class SortNameBase extends SequenceLongBase implements SortBase<String>{

	private static final long serialVersionUID = -950822256693332353L;

	@NotBlank
	@Column(name="sort_name" , nullable=false, columnDefinition = "VARCHAR NOT NULL")
	protected String sortName;
	
	public SortNameBase(@NotBlank String sortName) {
		super();
		this.sortName = sortName;
	}

	public SortNameBase() {
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sortName == null) ? 0 : sortName.hashCode());
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
		SortNameBase other = (SortNameBase) obj;
		if (sortName == null) {
			if (other.sortName != null)
				return false;
		} else if (!sortName.equals(other.sortName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SortNameBase [sortName=" + sortName + ", id=" + id + "]";
	}

}
