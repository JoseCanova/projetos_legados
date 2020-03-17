package org.nanotek;

import java.io.Serializable;

public interface TypeBase<K extends Serializable> extends MutableTypeBase<K> {
	K getType();
}
