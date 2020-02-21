package org.nanotek;

@FunctionalInterface
public interface Mediator<T> {
	void mediate(T t);
}
