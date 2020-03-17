package org.nanotek;

import java.io.Serializable;

public interface MutableDescriptionBase<K extends IdBase<K,ID>, D extends Serializable , ID extends Serializable> extends EntityBase<K,ID>{

	void setDescription(D id);

}
