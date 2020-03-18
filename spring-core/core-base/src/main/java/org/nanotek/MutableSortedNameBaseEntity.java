package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public interface SortedNameBase<K extends Serializable> {

	K getSortName();
	void setSortName(@NotBlank K sortName);
	
	default SortedNameBase<K> withSortName(K sortName){ 
		this.setSortName(sortName);
		return this;
	}
}
