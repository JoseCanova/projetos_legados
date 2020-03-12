package org.nanotek;

public class BaseHolder<K extends Base> implements ImmutableStringBase {
	
	private static final long serialVersionUID = 1230174889204486587L;
	
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
	
	static <K extends Base> BaseHolder<K> of (K k) { 
		return new BaseHolder<K>(k);
	}
}
