package org.nanotek;

import java.io.Serializable;

import org.nanotek.entities.MutableDescriptionBase;

public interface BaseDescriptionBase<K extends IdBase<K,ID> , D extends Serializable, ID extends Serializable> extends MutableDescriptionBase<K , D , ID> {

	D getDescription();
}
