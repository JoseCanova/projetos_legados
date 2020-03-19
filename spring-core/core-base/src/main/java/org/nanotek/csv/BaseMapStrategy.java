package org.nanotek.csv;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;
import org.nanotek.Base;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

@FunctionalInterface
public interface BaseMapStrategy<K extends WrappedBaseClass<K,ID>, ID extends IdBase<ID,?>> extends Base<K>{

    Optional<Result<K,?>> findProperty(Predicate<Class<ID>> evaluator);

    default  Optional<K> createBean(Class<K> k , Class<ID> id){ 
    	return this.newInstance (k , id);
    }
	
}
