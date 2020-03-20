package org.nanotek.csv;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.BaseException;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;
import org.nanotek.beans.csv.AreaBean;
import org.nanotek.beans.entity.Area;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;


public class MapStrategy<K extends WrappedBaseClass<J,ID>,ID extends IdBase<ID,?> , J extends BaseMap<J,ID>, B extends Result<J,ID>> 
implements BaseMapStrategy<K,ID,J>{
	
	MapColumnStrategy<J,ID> mapColumnStrategy;
	
	Optional<J> optResultBean;

	private static final long serialVersionUID = 1L;

	public MapStrategy(Class<J> j , Class<ID> i) {
		
		optResultBean = createBean(j,i);
		
		optResultBean.ifPresent(baseMap -> {
			 Optional<MapColumnStrategy> opt =  Base.newInstance
					 							(MapColumnStrategy.class , 
					 									new Serializable[] {baseMap , baseMap.getId()},new Class<?>[] {j , i});
		});
		
	}

	@Override
	public Optional<Result<ID, ?>> findProperty(String property) {
		try { 
				Optional<PropertyDescriptor> descriptor = findDescriptor(property);
				descriptor.ifPresent(d ->{
					optResultBean.get().getId();
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
		Optional<BaseMap> map = Base.newInstance(BaseMap.class, new Serializable[] {BaseMap.class}, Serializable.class);
//		BaseMapStrategy<?,?,?> ms = new MapStrategy(BaseMap.class,Area.class);
		
		System.out.println("the halt");
	}

	@Override
	public J getBaseMapClass() {
		return null;
	}
	
}
