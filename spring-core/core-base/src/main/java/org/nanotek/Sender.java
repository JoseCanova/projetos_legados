package org.nanotek;

@FunctionalInterface
public interface Sender<T,I> {

	public I send(T t);
	
}
