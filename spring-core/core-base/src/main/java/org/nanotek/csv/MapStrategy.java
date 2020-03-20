package org.nanotek.csv;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.BaseException;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.entity.Artist;
import org.nanotek.opencsv.BaseMap;


public class MapStrategy<K extends WrappedBaseClass<J,ID>,ID extends IdBase<ID,?> , J extends BaseMap<J,ID>, B extends Result<J,ID>> 
implements BaseMapStrategy<K,ID,J,B>{
	
	Optional<J> optionalIdBaseMap;
	
	Optional<K> optionalWrapperBean;
	
	Optional<B> resultBean;
	
	Optional<ID> identityClass;
	

	public MapStrategy(Class<K> k , Class<ID> i , Class<J> j , Class<B> b) {
		
		optionalIdBaseMap = createIdBaseClass(j, i);
		resultBean = createResultClass(b, i);
		optionalWrapperBean = createWrappedBaseClass(k, i);
		identityClass = createIdentityClass(i);
		
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
		Optional<BaseMap> map = Base.newInstance(BaseMap.class);
		map.get().setId(new Artist());
		System.out.println(map.get().getId());
		
		Optional<BaseMap> ms = Base.newInstance(BaseMap.class, 
												new Serializable[] {new Artist()},
												Serializable.class);
		System.out.println(ms.get().getId());
		
	
		Constructor[] constructors  = MapStrategy.class.getDeclaredConstructors();
		
		for (Constructor c : constructors) { 
			Parameter[] parameters = c.getParameters();
			for (Parameter p : parameters) { 
				System.out.println(p.getType().getTypeName());
			}
		}
		
		MapStrategy strategy = new MapStrategy(WrappedBaseClass.class,
														Artist.class,
														BaseMap.class,
														ArtistBean.class);
		
//		Optional<?> opt = Base.newInstance(MapStrategy.class, 
//								new Serializable[] {BaseMap.class,Artist.class,ArtistBean.class,WrappedBaseClass.class},
//								Class.class,Class.class,Class.class,Class.class);
		
		
		
		System.out.println("the halt");
	}

}
