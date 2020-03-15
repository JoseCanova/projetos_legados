package org.nanotek;

@FunctionalInterface
public interface Evaluator<K> {
	void evaluate(K k);
}
