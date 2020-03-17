package org.nanotek;

import java.io.Serializable;

public interface MutableLocaleEntity<K extends Serializable> extends LocaleEntity<K>{

	void setLocale(K k);
}
