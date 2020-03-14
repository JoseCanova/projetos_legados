package org.nanotek;

import java.io.Serializable;

public interface BaseDescriptionBase<K extends Serializable , ID extends Serializable> extends MutableDescriptionBase<K , ID> {

	K getDescription();
}
