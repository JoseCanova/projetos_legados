package org.nanotek.opencsv;

import java.util.Optional;
import java.util.stream.Stream;

import org.nanotek.Base;
import org.nanotek.BaseException;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;
import org.nanotek.WrappedEntityBase;
import org.nanotek.beans.csv.BaseBean;
import org.nanotek.stream.KongStream;


public class MapStrategyIdBase
<K extends WrappedEntityBase<J>, 
ID extends IdBase<ID,?> , 
J extends BaseBean<J,ID> , 
B extends ResultHolderBaseMap<ID,ID,K>> 
implements MapStrategy<K,ID,J,B>{
	
	Optional<J> optionalIdBaseMap;
	
	Optional<ID> optionalWrapperBean;
	
	Optional<ID> identityClass;
	
	Optional<B> resultBean;
	
	
	public <S extends J> J asIdBean(Class<J> j) { 
		Optional<J> instance = Base.newInstance(j.asSubclass(j));
		Stream<J> sj =  KongStream.of(j).add(instance.get()).build();
		return sj.findFirst().get(); 
	}

	
	static <KK extends K,  
				K extends WrappedBaseClass<KK,IID> , 
				IID extends ID,
				ID extends IdBase<IID , ?>,
				JJ extends J, 
				J extends IdBase<JJ,ID>,
				BB extends B, 
				B extends ResultHolderBaseMap<IID,IID,KK>>
				MapStrategyIdBase<KK,IID,JJ,BB> withClasses(Class<KK> k, Class<IID> i , Class<JJ> j , Class<BB> b) {
		
		
		return new MapStrategyIdBase(k , i , j , b);
		
	}

	

	public MapStrategyIdBase(Class<K> k, Class<ID> i , Class<J> j , Class<B> b) {
		
		optionalIdBaseMap = createIdBaseClass(j, i);
		identityClass = createIdentityClass(i);
		optionalWrapperBean = createWrappedBaseClass(i);
		resultBean= resultHolderBaseMap(i, identityClass.get());
		optionalIdBaseMap.ifPresent(id ->{
			resultBean.ifPresent(result ->{
				try {
					result.afterPropertiesSet();
				} catch (Exception e) {
					e.printStackTrace();
				}
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


}
