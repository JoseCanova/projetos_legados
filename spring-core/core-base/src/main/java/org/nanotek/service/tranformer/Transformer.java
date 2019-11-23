package org.nanotek.service.tranformer;

@FunctionalInterface
public interface Transformer<I, R> {
	public R transform(I i);
}
