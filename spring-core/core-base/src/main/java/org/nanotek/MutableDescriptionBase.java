package org.nanotek;

import java.io.Serializable;

public interface MutableDescriptionBase<K extends IdBase<K,ID>, D extends IdBase<D,ID> , ID extends Serializable> extends EntityBase<K,ID>{

	void setDescription(D id);

}
