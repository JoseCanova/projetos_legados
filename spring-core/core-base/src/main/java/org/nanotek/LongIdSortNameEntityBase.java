package org.nanotek;

import java.io.Serializable;

public interface LongIdSortNameEntityBase<T extends Serializable> extends LongIdEntityBase {

	T getSortName();
	
}
