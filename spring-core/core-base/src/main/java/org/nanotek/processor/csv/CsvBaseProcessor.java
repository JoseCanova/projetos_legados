package org.nanotek.processor.csv;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.Base;
import org.nanotek.BaseException;
import org.nanotek.ImmutableBase;
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

    public R next(){

    	String[] instanceArray = null;
    	Optional<R> bean = null;
    	BaseMapColumnStrategy <? , ? > m = parser.getBaseMapColumnStrategy();
    	try { 
		    	if ((instanceArray = getBaseParser().readNext()) !=null) {
		    		bean = computeInstanceArray(instanceArray);
		    	}
    	}catch (Exception ex) { 
    		throw new BaseException(ex);
    	}
    	return bean.orElseThrow(BaseException::new);
    }
    
    private Optional<R> computeInstanceArray(String[] instanceArray)  {
    	BaseMapColumnStrategy <? , ? > m = parser.getBaseMapColumnStrategy();
    	Base<?> base = Base.newInstance(m.getType()).get();
    	m.getBaseMap().entrySet().forEach((e)->{
    		try {
				Optional.ofNullable(m.findDescriptor(e.getValue())).ifPresent(d ->{
					String value = instanceArray[e.getValue()];
					Object obj;
					try {
						obj = csvToBean.convertValue(value, d);
						d.getWriteMethod().invoke(base, obj);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
			} catch (Exception e1) {
				e1.printStackTrace();
			}
    	});
		return ImmutableBase.newInstance(Result.class , Arrays.asList(base).toArray() , base.getClass());
	}

	public List<Optional<R>> load(@NotNull Long count) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
    	List<Optional<R>> list = new  ArrayList<>();
    	int i = 0;
    	String[] instanceArray = null;
    	while (i < count && (instanceArray = getBaseParser().readNext()) !=null) {
    		Optional<R> bean = computeInstanceArray(instanceArray);
    		list.add(bean);
    		i++;
    	}
    	return list;
    }	

}
