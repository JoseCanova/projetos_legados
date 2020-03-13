package org.nanotek;

import java.io.Serializable;

public interface Locale<K extends Serializable> extends Base{

	K getLocale();
	void setLocale(K k);
	
}
