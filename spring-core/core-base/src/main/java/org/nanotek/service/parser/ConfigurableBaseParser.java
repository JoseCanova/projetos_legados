package org.nanotek.service.parser;

import org.nanotek.Base;
import org.nanotek.base.maps.BaseMapColumnStrategy;

import au.com.bytecode.opencsv.CSVReader;

public class ConfigurableBaseParser<T extends Base> extends BaseParser {

	private BaseMapColumnStrategy<T> baseMap;
	
	public ConfigurableBaseParser() {
	}

	public ConfigurableBaseParser(CSVReader csvReader) {
		super(csvReader);
	}
	
	public ConfigurableBaseParser(BaseMapColumnStrategy<T> baseMap) {
		this.baseMap = baseMap;
	}
	
	@Override
	public BaseMapColumnStrategy<?> getBaseMap() {
		return baseMap;
	}

}
