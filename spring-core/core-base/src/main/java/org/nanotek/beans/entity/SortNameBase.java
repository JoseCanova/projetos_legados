package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.nanotek.BaseEntity;
import org.nanotek.MutableSortNameEntity;

@Entity
@Table(name="sort_name_base",
							indexes= {
									@Index(unique = false , name = "sort_name_idx" , columnList ="sort_name")
								})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    discriminatorType = DiscriminatorType.STRING,
	    name = "table_id",
	    columnDefinition = "VARCHAR NOT NULL"
	)
public class SortNameBase<K extends Serializable> extends SequenceLongBase<SortNameBase<K>> implements MutableSortNameEntity<String> , BaseEntity{

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
}
