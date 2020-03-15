package org.nanotek.csv;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;
import org.nanotek.Base;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

@FunctionalInterface
public interface BaseMapStrategy<K extends WrappedBaseClass<ID>, ID extends Base<?>> {

    Optional<Result<?>> findProperty(Predicate<Class<ID>> evaluator);

    default Optional<K> createBean(Class<K> clazz){ 
    	return Base.newInstance(clazz);
    }
	
}
