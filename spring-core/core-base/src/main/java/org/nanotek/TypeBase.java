package org.nanotek;

import org.nanotek.beans.entity.BaseTypeEntityBase;

public interface TypeBase<K extends BaseTypeEntityBase<?,?>> extends MutableTypeBase<K> {
	K getType();
}
