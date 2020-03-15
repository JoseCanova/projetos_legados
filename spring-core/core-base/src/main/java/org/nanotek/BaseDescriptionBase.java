package org.nanotek;

import java.io.Serializable;

public interface BaseDescriptionBase<K extends IdBase<K,ID> , D extends IdBase<K,ID>, ID extends Serializable> extends MutableDescriptionBase<K , K , ID> {

	D getDescription();
}
