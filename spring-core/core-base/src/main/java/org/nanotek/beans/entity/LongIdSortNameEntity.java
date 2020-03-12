package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.nanotek.SortedNameBase;

@Entity
@Table(name="long_id_sort_name")
public class LongIdSortNameEntity extends LongIdNameEntity implements SortedNameBase<String> {

	private static final long serialVersionUID = -3442197714885490996L;

	@NotBlank
	@Column(name="sort_name" , nullable=false, columnDefinition = "VARCHAR NOT NULL")
	protected String sortName;
	
	public LongIdSortNameEntity() {
	}

	public LongIdSortNameEntity(@NotBlank String name) {
		super(name);
	}
	
	public LongIdSortNameEntity(@NotBlank String name , @NotBlank String sortName) {
		super(name);
		this.sortName = sortName;
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LongIdSortNameEntity other = (LongIdSortNameEntity) obj;
		if (sortName == null) {
			if (other.sortName != null)
				return false;
		} else if (!sortName.equals(other.sortName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LongIdSortNameEntity [sortName=" + sortName + ", name=" + name + ", id=" + id + "]";
	}
	
}
