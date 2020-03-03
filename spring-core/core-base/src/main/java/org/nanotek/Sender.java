package org.nanotek;

@FunctionalInterface
public interface Sender<T> {

	public T send(T t);
	
}
