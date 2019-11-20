package org.nanotek.service.parser;

import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.opencsv.BaseMap;

public class BaseMapParser<T extends BaseMap<?>> extends BaseParser{
	
	private BaseMapColumnStrategy<T> baseMap;

	public BaseMapParser() {}
	
	public BaseMapParser(BaseMapColumnStrategy<T> baseMap) {
		super();
		this.baseMap = baseMap;
	}


	public void setBaseMap(BaseMapColumnStrategy<T> baseMap) {
		this.baseMap = baseMap;
	}

	@Override
	public BaseMapColumnStrategy<?> getBaseMap() {
		return baseMap;
	}
	
}
