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
	
	default Object createWrappedBaseClass(Class<J> clazz,Class<ID> i){ 
		ID in = createIdBaseClass(i).get();
		J jon = BaseBean.newInstance(clazz, new Object[] {in}, i).get();
		return WrappedEntityBase.newBaseBeanInstance(clazz);
	}

	default Optional<ID> createIdBaseClass(Class<ID> id){ 
		return Base.newInstance (id);
	}
	
	default Optional<ID> createIdentityClass(Class<ID> k){
		return Base.newInstance(k);
	}
	
}
