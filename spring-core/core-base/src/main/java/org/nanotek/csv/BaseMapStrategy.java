package org.nanotek.csv;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;
import org.nanotek.Base;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

@FunctionalInterface
public interface BaseMapStrategy<K extends WrappedBaseClass<J,?>, ID extends IdBase<ID,?> , J extends ID>  extends Base<J>{

    Optional<Result<ID,?>> findProperty(Predicate<Class<ID>> evaluator , String property);
    

    default  Optional<J> createBean(Class<J> k , Class<ID> id){ 
    	return this.newInstance (k , id);
    }
	
}
