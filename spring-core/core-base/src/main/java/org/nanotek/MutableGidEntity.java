package org.nanotek;

import java.io.Serializable;

public interface MutableGidEntity<K extends Serializable> extends GidEntity<K>{
	void setGid(K k);
}
