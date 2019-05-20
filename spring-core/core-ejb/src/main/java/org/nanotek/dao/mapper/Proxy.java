package org.nanotek.dao.mapper;

import javax.validation.constraints.NotNull;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public interface Proxy<T> {

	static final Enhancer enhancer = new Enhancer();
	
    @SuppressWarnings("unchecked")
	default <I extends T> I  createProxy(@NotNull T instance) {
        enhancer.setSuperclass(instance.getClass());
        enhancer.setCallback(NoOp.INSTANCE);
        return (I) enhancer.create();
   }
    
}
