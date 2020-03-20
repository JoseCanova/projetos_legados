package org.nanotek.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

public interface MapStrategy<K extends WrappedBaseClass<J,ID>, ID extends IdBase<ID,?> , 
J extends IdBase<J,ID> , B extends Result<J,ID>>  
{

	Optional<Result<ID,?>> findProperty(String property);

	default Optional<K> createWrappedBaseClass(Class<K> k , Class<ID> id){ 
		return Base.newInstance (k , id);
	}

	default  Optional<J> createIdBaseClass(Class<J> k , Class<ID> id){ 
		return Base.newInstance (k , id);
	}
	
	default Optional<ID> createIdentityClass(Class<ID> k){
		return Base.newInstance(k);
	}
	
}
