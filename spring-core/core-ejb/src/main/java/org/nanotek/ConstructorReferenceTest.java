package org.nanotek;

import java.util.Optional;
import java.util.function.Supplier;

public class ConstructorReferenceTest {

	public ConstructorReferenceTest() {
	}

	public static void main(String[] args) {
		
		Object obj = orElseTest(null, Object::new); 
		
		obj = new Object(); 
		System.out.println(" HashCode " + obj.hashCode());
		orElseTest(obj, new SupplierGetter<Object>(Object::new));
		System.out.println(" HashCode " + obj.hashCode());
		
		
	}

	
	static <T> T orElseTest(T object , Supplier <T> supplier)
	{ 
		object = Optional.ofNullable(object).orElseGet(supplier); 
		return object;
	}
	
}
