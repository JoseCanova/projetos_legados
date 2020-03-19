package org.nanotek.csv;

import java.beans.PropertyDescriptor;
import java.util.Optional;

import org.nanotek.BaseException;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;
import org.nanotek.beans.csv.AreaBean;
import org.nanotek.beans.entity.Area;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;


public class MapStrategy<K extends WrappedBaseClass<J,?>,ID extends IdBase<ID,?> , J extends ID, B extends BaseMap<J,?>> 
implements BaseMapStrategy<K,ID,J>{
	
	MapColumnStrategy<B> mapColumnStrategy;
	
	Optional<J> baseMapClass;

	private static final long serialVersionUID = 1L;

	public MapStrategy(Class<J> j , Class<ID> i) {
		baseMapClass = createBean(j,i);
	}

	@Override
	public Optional<Result<ID, ?>> findProperty(String property) {
		try { 
				Optional<PropertyDescriptor> descriptor = findDescriptor(property);
				descriptor.ifPresent(d ->{
					baseMapClass.get().getId();
				});
		}catch(Exception ex) { 
			throw new BaseException(ex);
		}
		return null;
	}
	
	Optional<PropertyDescriptor> findDescriptor(String property){
		try { 
				PropertyDescriptor descriptor = mapColumnStrategy.findDescriptor(property);
				return Optional.ofNullable(descriptor);
		}catch(Exception ex) { 
			throw new BaseException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public static void main (String[] args) { 
		MapStrategy<?,?,?,?> ms = new MapStrategy(AreaBean.class,Area.class);
		System.out.println("the halt");
	}
	
}
