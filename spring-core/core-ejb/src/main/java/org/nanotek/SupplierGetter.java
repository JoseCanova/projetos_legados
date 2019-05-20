package org.nanotek;

import java.util.function.Supplier;

public class SupplierGetter <T> implements Supplier<T>{

	private Supplier<T> instance; 
	
	public SupplierGetter(Supplier<T> instance)
	{ 
		assert(instance !=null);
		this.instance = instance;
	}
	
	@Override
	public T get() {
		System.out.println("Using the supplier constructor");
		return instance.get();
	} 
	
}