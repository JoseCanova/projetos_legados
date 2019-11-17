package org.nanotek.opencsv;

import org.nanotek.Base;
import org.nanotek.PostConstructorStrategy;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class    MapColumnStrategy<T extends BaseMap<Class<Base<?>>>, I extends Base<?>> 
extends     ColumnPositionMappingStrategy<I>  
implements PostConstructorStrategy<T> {

	private T baseMap; 
	
	public MapColumnStrategy(T baseMap) {
		super();
		this.baseMap = baseMap;
		buildMapping();
	}


	@Override
	public void buildMapping() {
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
