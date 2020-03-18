package org.nanotek.entities;

import org.nanotek.Base;

public interface MutableLength<T> extends Base<MutableLength<T>>{

	void setLength(MutableLength<T> l);
	
	
}
