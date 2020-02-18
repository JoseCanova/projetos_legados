package org.nanotek;

public class BaseHolder<K extends Base<?>> implements ImmutableStringBase {
	
	private K base;
	
	public BaseHolder(K base) { 
		this.base = base;
	}

	@Override
	public String getId() { 
		return md5Digest();
	}

	public K getBase() { 
		return base;
	}
	
}
