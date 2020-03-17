package org.nanotek.controller;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.Result;
import org.nanotek.base.maps.BaseMapColumnStrategy;
import org.nanotek.opencsv.MapColumnStrategy;
import org.nanotek.processor.csv.CsvBaseProcessor;
import org.nanotek.service.parser.BaseParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import au.com.bytecode.opencsv.bean.CsvToBean;

public abstract class CsvController<P extends CsvBaseProcessor<?,?,R> , R extends Result<?,?>> {

	P processor;
		
	@RequestMapping("/map_config")
    public MapColumnStrategy<? , ?> getBaseMapColumnStrategy() {
        return processor.getBaseParser().getBaseMapColumnStrategy();
    }


    @RequestMapping("/next")
    public R next()  {
    	return processor.next();
    }


    @RequestMapping("/load")
    public List<Optional<R>> load(@RequestParam(value="count", defaultValue="1") Long count)  {
    	return processor.load(count);
    }	
	
}
