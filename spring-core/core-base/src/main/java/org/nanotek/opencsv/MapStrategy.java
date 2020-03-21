package org.nanotek.opencsv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;

public interface MapStrategy
<K extends IdBase<K,ID>, 
ID extends IdBase<ID,?> , 
J extends IdBase<K,ID> , 
B extends ResultHolderBaseMap<ID,ID,K>>  
{

	Optional<Result<ID,?>> findProperty(String property);

	default Optional<B> resultHolderBaseMap(Class<ID> ci, ID i){
		return  Optional.of(new ResultHolderBaseMap(i,ci));
	}
	
	default Optional<ID> createWrappedBaseClass(Class<ID> clazz){ 
		return Base.newWrappedInstance(clazz);
	}

	default <JJ extends J , IID extends ID> Optional<JJ> createIdBaseClass(Class<JJ> k , Class<IID> id){ 
		return Base.newInstance (k , id);
	}
	
	default Optional<ID> createIdentityClass(Class<ID> k){
		return Base.newInstance(k);
	}
	
}
