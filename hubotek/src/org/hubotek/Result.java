package org.hubotek;

import java.io.Serializable;

public interface Result<T> extends Serializable{

	T get();
	
}
