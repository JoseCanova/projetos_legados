package org.nanotek;

import java.io.Serializable;

public interface MutableLongIdNameEntity<K extends Serializable> extends LongIdNameEntity<K>{
	
	void setName(K k);

}
