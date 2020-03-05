package org.nanotek.processor.csv;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.nanotek.Base;
import org.nanotek.opencsv.MapColumnStrategy;
import org.nanotek.service.parser.BaseMapParser;

import au.com.bytecode.opencsv.bean.CsvToBean;

public class CsvBaseProcessor<I extends Base, P extends BaseMapParser<I>> {

	
	private P parser; 
	
	private CsvToBean<I> csvToBean;
	
	public CsvBaseProcessor(P parser, CsvToBean<I> csvToBean) {
		super();
		this.parser = parser;
		this.csvToBean = csvToBean;
	}

	CsvToBean<I> getCsvToBean(){ 
		return csvToBean;
	}

	P getBaseParser() {
		return parser;
	}
	
    public MapColumnStrategy<? , ?> mapConfig() {
        return getBaseParser().getBaseMap();
    }

    public void reopenFile() throws Exception {
         getBaseParser().reopen();
    }

    public I next() throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
    	String[] instanceArray = null;
    	I bean = null;
    	if ((instanceArray = getBaseParser().readNext()) !=null) {
    		bean = getCsvToBean().processLine(parser.getBaseMap(), instanceArray);
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
