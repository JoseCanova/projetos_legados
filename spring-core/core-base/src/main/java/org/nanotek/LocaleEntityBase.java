package org.nanotek;

import java.io.Serializable;

public interface LocaleEntityBase<K extends Serializable> extends LongIdEntityBase , MutableBase<Long>{

	
	K getLocale();
	
	void setLocale(K k);
	
}
