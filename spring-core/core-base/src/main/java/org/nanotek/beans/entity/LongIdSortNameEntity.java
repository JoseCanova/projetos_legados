package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.nanotek.SortedNameBase;

@MappedSuperclass
public class LongIdSortNameEntity extends LongIdNameEntity implements SortedNameBase{

	private static final long serialVersionUID = -3442197714885490996L;

	@NotNull
	@Column(name="sort_name" , nullable=false, columnDefinition = "VARCHAR NOT NULL")
	protected String sortName;
	
	public LongIdSortNameEntity() {
	}

	public LongIdSortNameEntity(@NotNull Long id) {
		super(id);
	}

	public LongIdSortNameEntity(@NotNull Long id , @NotNull String name) {
		super(id,name);
	}
	
	public LongIdSortNameEntity(@NotNull Long id , @NotNull String name , @NotNull String sortName) {
		super(id,name);
		this.sortName = sortName;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	
}
