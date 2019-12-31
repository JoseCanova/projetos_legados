package org.nanotek.opencsv;

import org.nanotek.Base;
import org.springframework.beans.factory.InitializingBean;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class MapColumnStrategy<T extends BaseMap<I>, I extends Base<?>> extends  ColumnPositionMappingStrategy<I> implements InitializingBean {

	protected T baseMap; 
	
	public MapColumnStrategy() {
		super();
	}

	public T getBaseMap() {
		return baseMap;
	}

	public void setBaseMap(T baseMap) {
		this.baseMap = baseMap;
	}

	public void afterPropertiesSet() {
		assert (baseMap !=null && baseMap.size() >=1);
		String [] csvColumns = new String[baseMap.getTargetSize()];
		try {
			for (Object key : baseMap.keySet()){ 
				Integer position = baseMap.get(key);
				if (position !=null)
					csvColumns[position] = key.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MappingStrategyException (e);
		}
		this.setColumnMapping(csvColumns);
	}

}
