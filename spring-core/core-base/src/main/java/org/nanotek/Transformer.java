package org.nanotek;

@FunctionalInterface
public interface Transformer<I, R> {
	public R transform(I i);
}
