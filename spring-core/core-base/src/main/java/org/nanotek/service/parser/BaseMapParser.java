package org.nanotek.service.parser;

import org.nanotek.Base;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.opencsv.BaseMap;

public class BaseMapParser<I extends Base> extends BaseParser{
	
	private BaseMapColumnStrategy<I> baseMap;

	public BaseMapParser() {}
	
	public BaseMapParser(BaseMapColumnStrategy<I> baseMap) {
		super();
		this.baseMap = baseMap;
	}


	public void setBaseMap(BaseMapColumnStrategy<I> baseMap) {
		this.baseMap = baseMap;
	}

	@Override
	public BaseMapColumnStrategy<I> getBaseMap() {
		return baseMap;
	}
	
}
