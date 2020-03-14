package org.nanotek;

import java.io.Serializable;

public interface MutableId<K extends Serializable> extends Mutable{
		void setId(K k);
}
