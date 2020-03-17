package org.nanotek;

import java.io.Serializable;

public interface MutableSortNameEntity<K extends Serializable> extends SortNameEntity<K>{
  
	void setSortName(K k);
	
}
