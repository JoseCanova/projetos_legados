package org.nanotek.service;

import org.springframework.stereotype.Service;

@Service
public class CsvProcessorService extends TextParser implements BaseService{
	
	public CsvProcessorService() {} 
	
	public CsvProcessorService(String fileLocation , String fieldDelimiter, String tupleDelimiter) { 
		this.fileLocation = fileLocation; 
		this.fieldDelimiter = fieldDelimiter; 
		this.tupleDelimiter = tupleDelimiter;
	}
}
