package org.nanotek.csv;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;
import org.nanotek.Base;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

public interface BaseMapStrategy<K extends WrappedBaseClass<?>, ID extends Base<?>> {

	/**
     * Implementation will have to return a property descriptor from a bean based on the current column.
     * @param col the column to find the description for
     * @throws java.beans.IntrospectionException
     * @return the related PropertyDescriptor
     */
    Optional<Result<?>> findProperty(Predicate<Class<ID>> evaluator);

    default Optional<K> createBean(Class<K> clazz){ 
    	return Base.newInstance(clazz)
    }
	
}
