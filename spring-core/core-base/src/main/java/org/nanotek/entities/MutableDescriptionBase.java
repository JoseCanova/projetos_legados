package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.EntityBase;
import org.nanotek.IdBase;

public interface MutableDescriptionBase<K extends IdBase<K,ID>, D extends Serializable , ID extends Serializable> extends EntityBase<K,ID>{

	void setDescription(D id);

}
