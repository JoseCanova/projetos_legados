package org.nanotek.service.parser;

import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.springframework.beans.factory.InitializingBean;

import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;

public abstract class BaseParser extends CSVParser implements InitializingBean , Closeable{

	protected CSVReader csvReader;
	
	public BaseParser() {}
	
	public BaseParser(CSVReader csvReader) { 
		this.csvReader = csvReader;
	}

	public CSVReader getCsvReader() {
		return csvReader;
	}

	public void setCsvReader(CSVReader csvReader) {
		this.csvReader = csvReader;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		openFileReader();
		
	}

	private void openFileReader() throws Exception{
		StringBuffer fileLocationStr = new StringBuffer();
		fileLocationStr.append(getBaseMap().getFileLocation())
		.append(System.getProperty("file.separator")).append(getBaseMap().getFileName().toString());
		FileReader fileReader = new FileReader(new File(fileLocationStr.toString()));
		csvReader = new CSVReader(fileReader , '\t');		
	}

	public List<String[]> readAll() throws IOException {
		return csvReader.readAll();
	}

	public String[] readNext() throws IOException {
		return csvReader.readNext();
	}

	@Override
	public void close() throws IOException {
		csvReader.close();
	}

	public void reopen() throws Exception { 
		csvReader.close();
		openFileReader();
	}
	
	public abstract BaseMapColumnStrategy<?> getBaseMap();

}
