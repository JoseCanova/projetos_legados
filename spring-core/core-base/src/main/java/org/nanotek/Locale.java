package org.nanotek;

import java.io.Serializable;

public interface Locale<K extends Serializable , ID extends Serializable> extends IdBase<ID>{

	
	default K getLocale() { 
		return get().getLocale();
	}
	
	default void setLocale(K k) {
		get().setLocale(k);
	}
	
	@Override
	default Locale<K , ID> get() {
		return this;
	}
	
}
