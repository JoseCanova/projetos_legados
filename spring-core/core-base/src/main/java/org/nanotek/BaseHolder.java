package org.nanotek;

public abstract class BaseHolder<K extends Base<?>> implements Holder<K> , ImmutableBase<ImmutableBase<?>>{
	
	private K base;
	
	public BaseHolder(K base) { 
		this.base = base;
	}
	
	

}
