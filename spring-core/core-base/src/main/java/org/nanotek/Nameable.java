package org.nanotek;

public interface Nameable<K> extends Kong<Nameable<K>> {
	
	@Override
	default  Nameable<K>  get() { 
		return this;
	}
}
