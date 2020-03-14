package org.nanotek;

import java.io.Serializable;

public interface MutableDescriptionBase<D extends Serializable , ID extends Serializable> extends EntityBase<ID>{

	void setDescription(D id);

}
