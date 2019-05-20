package org.nanotek.integration;

public interface Transformation<T, I> {

	T transform (I info);
	
}
