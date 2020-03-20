package org.nanotek.opencsv;

import java.util.Optional;

import org.nanotek.BaseException;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;


public class MapStrategyIdBase
<K extends WrappedBaseClass<K,ID>, 
ID extends IdBase<ID,?> , 
J extends IdBase<K,ID> , 
B extends ResultHolderBaseMap<ID,ID,K>> 
implements MapStrategy<K,ID,J,B>{
	
	Optional<J> optionalIdBaseMap;
	
	Optional<K> optionalWrapperBean;
	
	Optional<B> resultBean;
	
	Optional<ID> identityClass;
	

	public MapStrategyIdBase(Class<K> k, Class<ID> i , Class<J> j , Class<B> b) {
		
		optionalIdBaseMap = createIdBaseClass(j, i);
		optionalWrapperBean = createWrappedBaseClass(k, i);
		identityClass = createIdentityClass(i);
		optionalIdBaseMap.ifPresent(id ->{
			resultBean.ifPresent(result ->{
				
			});
		});;

		
		
		
		System.out.println(this.toString());
	}

	@Override
	public Optional<Result<ID, ?>> findProperty(String property) {
		try { 
//				Optional<PropertyDescriptor> descriptor = findDescriptor(property);
//				descriptor.ifPresent(d ->{
//					optResultBean.get().getId();
//				});
		}catch(Exception ex) { 
			throw new BaseException(ex);
		}
		return null;
	}
	
//	Optional<PropertyDescriptor> findDescriptor(String property){
//		try { 
//				PropertyDescriptor descriptor = mapColumnStrategy.findDescriptor(property);
//				return Optional.ofNullable(descriptor);
//		}catch(Exception ex) { 
//			throw new BaseException(ex);
//		}
//	}

	@SuppressWarnings("unchecked")
	public static void main (String[] args) { 
	}

}
