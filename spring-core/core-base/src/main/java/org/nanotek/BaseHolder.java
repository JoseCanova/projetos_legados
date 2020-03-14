package org.nanotek;

public abstract class BaseHolder<K extends Base<?>> implements Holder<K>{
	
	private K base;
	
	public BaseHolder(K base) { 
		this.base = base;
	}

}
