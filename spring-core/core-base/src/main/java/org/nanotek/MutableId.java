package org.nanotek;

import java.io.Serializable;

public interface MutableId<K extends IdBase<K,ID> , ID extends Serializable> extends Mutable<K,ID>{
		void setId(ID k);
}
