package org.nanotek.service.parser;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;

import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.springframework.beans.factory.InitializingBean;

import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;

public abstract class BaseParser extends CSVParser implements InitializingBean , Closeable{

	protected CSVReader csvReader;

	public CSVReader getCsvReader() {
		return csvReader;
	}

	public void setCsvReader(CSVReader csvReader) {
		this.csvReader = csvReader;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		StringBuffer fileLocationStr = new StringBuffer();
		fileLocationStr.append(getBaseMap().getFileLocation())
							.append(System.getProperty("file.separator")).append(getBaseMap().getFileName().toString());
		FileReader fileReader = new FileReader(new File(fileLocationStr.toString()));
		csvReader = new CSVReader(fileReader , '\t');
	}
	
	public abstract BaseMapColumnStrategy<?> getBaseMap();
}
