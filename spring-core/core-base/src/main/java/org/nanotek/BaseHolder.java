package org.nanotek;

public abstract class BaseHolder<K extends Base<?>> implements  ImmutableBase<K>{
	
	private static final long serialVersionUID = 1063313814504252299L;
	
	private K id; 
	
	public BaseHolder(K base) { 
		this.id = base;
	}
	
	@Override
	public K getId() {
		return id;
	}

}
