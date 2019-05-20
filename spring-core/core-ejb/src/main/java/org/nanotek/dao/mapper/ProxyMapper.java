package org.nanotek.dao.mapper;

import org.apache.commons.beanutils.BeanUtils;
import org.nanotek.Base;

public interface ProxyMapper<T extends Base<?> , I extends T> extends BaseMapper<T,I> , Proxy<T>{

	
    @Override
    default I apply(T t){ 
    	I i = createProxy(t);
    	try {
    		 BeanUtils.copyProperties(i, t);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
    	return i;
    }
    
}
