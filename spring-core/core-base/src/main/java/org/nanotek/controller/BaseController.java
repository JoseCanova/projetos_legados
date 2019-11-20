package org.nanotek.controller;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

import org.nanotek.Base;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.opencsv.MapColumnStrategy;
import org.nanotek.service.parser.BaseParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import au.com.bytecode.opencsv.bean.CsvToBean;

public abstract class BaseController<T extends BaseMapColumnStrategy<I> , I extends Base<?>> {

	public abstract T getBaseMap();

	public abstract CsvToBean<I> getCsvToBean();

	public abstract BaseParser getBaseParser();
	
	
	@RequestMapping("/map_config")
    public MapColumnStrategy<? , ?> mapConfig(@RequestParam(value="count", defaultValue="1") Long count) {
        return getBaseParser().getBaseMap();
    }

	
    @RequestMapping("/next")
    public I next() throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
    	String[] instanceArray = null;
    	I bean = null;
    	if ((instanceArray = getBaseParser().readNext()) !=null) { 
    		bean = getCsvToBean().processLine(getBaseMap(), instanceArray);
    	}
    	return bean;
    }

	
    @RequestMapping("/load")
    public List<I> load(@RequestParam(value="count", defaultValue="1") Long count) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
    	List<I> list = new  ArrayList<>();
    	int i = 0;
    	String[] instanceArray = null;
    	while (i < count && (instanceArray = getBaseParser().readNext()) !=null) { 
    		I bean = getCsvToBean().processLine(getBaseMap(), instanceArray);
    		list.add(bean);
    		i++;
    	}
    	return list;
    }

}
