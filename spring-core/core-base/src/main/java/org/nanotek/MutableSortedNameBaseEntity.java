package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public interface MutableSortedNameBaseEntity<K extends Serializable> extends SortNameBaseEntity<K> {

	void setSortName(@NotBlank K sortName);
	
	default MutableSortedNameBaseEntity<K> withSortName(K sortName){ 
		this.setSortName(sortName);
		return this;
	}
}
