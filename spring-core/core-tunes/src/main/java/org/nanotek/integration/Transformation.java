package org.nanotek.integration;

@FunctionalInterface
public interface Transformation<T, I> {

	T transform (I info);
	
}
