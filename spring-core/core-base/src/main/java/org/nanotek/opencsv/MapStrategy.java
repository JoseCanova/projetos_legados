package org.nanotek.opencsv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

public interface MapStrategy
<K extends WrappedBaseClass<K,ID>, 
ID extends IdBase<ID,?> , 
J extends IdBase<K,ID> , 
B extends ResultHolderBaseMap<ID,ID,K>>  
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
