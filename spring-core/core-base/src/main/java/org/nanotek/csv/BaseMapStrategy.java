package org.nanotek.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

public interface BaseMapStrategy<K extends WrappedBaseClass<J,ID>, ID extends IdBase<ID,?> , J extends IdBase<J,ID>>  extends Base<J>{

    Optional<Result<ID,?>> findProperty(String property);
    

    default  Optional<J> createBean(Class<J> k , Class<ID> id){ 
    	return this.newInstance (k , id);
    }
    
    J getBaseMapClass();
	
}
