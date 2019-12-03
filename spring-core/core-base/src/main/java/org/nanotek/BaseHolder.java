package org.nanotek;

public class BaseHolder<K extends Base<?>> implements Base <String>{
	
	private static final long serialVersionUID = 4805149675951813265L;
	
	private K base;
	
	public BaseHolder(K base) { 
		this.base = base;
	}

	@Override
	public String getId() { 
		return md5Digest();
	}

	@Override
	public void setId(String id) {
		throw new RuntimeException("cannot alter id of the holder");
	}

	public K getBase() { 
		return base;
	}
	
}
