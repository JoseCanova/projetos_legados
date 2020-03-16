package org.nanotek.processor.csv;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.nanotek.BaseException;
import org.nanotek.Result;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.processor.ProcessorBase;
import org.nanotek.service.parser.BaseMapParser;

import au.com.bytecode.opencsv.bean.CsvToBean;

public class CsvBaseProcessor<I extends BaseMapColumnStrategy<?, ?>, P extends BaseMapParser<I,?>, R extends Result<?,?>> implements ProcessorBase<I,P,R>{

	private P parser; 
	
	private CsvToBean<?> csvToBean;
	
	public CsvBaseProcessor(P parser, CsvToBean<?> csvToBean) {
		super();
		this.parser = parser;
		this.csvToBean = csvToBean;
	}

	CsvToBean<?> getCsvToBean(){ 
		return csvToBean;
	}

	public P getBaseParser() {
		return parser;
	}
	
    public void reopenFile() throws Exception {
         getBaseParser().reopen();
    }

    public I next() throws BaseException {
    	String[] instanceArray = null;
    	I bean = null;
    	try { 
		    	BaseMapColumnStrategy <? , ? > m = parser.getBaseMapColumnStrategy();
		    	if ((instanceArray = getBaseParser().readNext()) !=null) {
		    		get
		    		bean = getCsvToBean().processLine(parser.getBaseMapColumnStrategy(), instanceArray);
		    	}
    	}catch(Exception ex) { 
    		
    	}
    	return bean;
    }
    
    public List<I> load(@NotNull Long count) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
    	List<I> list = new  ArrayList<>();
    	int i = 0;
    	String[] instanceArray = null;
    	while (i < count && (instanceArray = getBaseParser().readNext()) !=null) {
    		I bean = getCsvToBean().processLine(parser.getBaseMap(), instanceArray);
    		list.add(bean);
    		i++;
    	}
    	return list;
    }	

}
