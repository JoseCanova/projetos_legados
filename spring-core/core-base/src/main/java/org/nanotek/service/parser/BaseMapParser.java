package org.nanotek.service.parser;

import java.io.Serializable;

import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;

public class BaseMapParser<K extends MapColumnStrategy<?,?>, I extends Serializable> extends BaseParser{
	
	private BaseMapColumnStrategy<?,?> baseMapColumnStrategy;
	
	public BaseMapParser() {}
	
	public BaseMapParser(BaseMapColumnStrategy<?,?> baseMapColumnStrategy) {
		super();
		this.baseMapColumnStrategy = baseMapColumnStrategy;
	}

	public void setBaseMap(BaseMapColumnStrategy<?,?> baseMapColumnStrategy) {
		this.baseMapColumnStrategy = baseMapColumnStrategy;
	}

	public BaseMap<?> getBaseMap() {
		return baseMapColumnStrategy.getBaseMap();
	}

	public void setFileName(String newFileName) {
		getBaseMapColumnStrategy().setFileName(newFileName);
	}

	public BaseMapColumnStrategy<?, ?> getBaseMapColumnStrategy() {
		return baseMapColumnStrategy;
	}

	public void setBaseMapColumnStrategy(BaseMapColumnStrategy<?, ?> baseMapColumnStrategy) {
		this.baseMapColumnStrategy = baseMapColumnStrategy;
	}
	
}
