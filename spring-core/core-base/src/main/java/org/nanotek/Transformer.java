package org.nanotek;

@FunctionalInterface
public interface Transformer<I, R> {
	R transform(I i);
}
