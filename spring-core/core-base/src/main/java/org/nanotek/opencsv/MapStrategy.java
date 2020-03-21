package org.nanotek.opencsv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedEntityBase;
import org.nanotek.beans.csv.BaseBean;

public interface MapStrategy
<K extends WrappedEntityBase<J>, 
ID extends IdBase<ID,?> , 
J extends BaseBean<ID> , 
B extends ResultHolderBaseMap<J,K>>  
{

	Optional<Result<ID,?>> findProperty(String property);

	default Optional<J> resultHolderBaseMap(Class<J> j){
		return  BaseBean.newInstance(j);
	}
	
	default Optional<ID> createWrappedBaseClass(Class<ID> clazz){ 
		return Base.newWrappedInstance(clazz);
	}

	default Optional<ID> createIdBaseClass(Class<ID> id){ 
		return Base.newInstance (id);
	}
	
	default Optional<ID> createIdentityClass(Class<ID> k){
		return Base.newInstance(k);
	}
	
}
