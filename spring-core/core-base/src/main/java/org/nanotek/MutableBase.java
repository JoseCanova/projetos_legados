package org.nanotek;

import java.io.Serializable;

@FunctionalInterface
public interface MutableBase<K extends Serializable> {

	void setId(K id);

}
