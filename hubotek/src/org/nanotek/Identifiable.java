package org.nanotek;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> extends Serializable {

	public T getId();
	
}
