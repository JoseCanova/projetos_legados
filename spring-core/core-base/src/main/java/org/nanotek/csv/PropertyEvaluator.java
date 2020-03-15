package org.nanotek.csv;

import java.util.function.Predicate;

import org.nanotek.Base;

public class PropertyEvaluator<K extends Base<?>> implements Predicate<K>{

	public PropertyEvaluator() {
	}

	@Override
	public boolean test(K arg0) {
		return false;
	}

}
