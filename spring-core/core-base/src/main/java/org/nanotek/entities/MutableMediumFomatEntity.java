package org.nanotek.entities;

import java.io.Serializable;

public interface MutableMediumFomatEntity<K extends Serializable> extends 
MutableNameEntity<String>,
MutableParentEntity<Long>,
MutableYearEntity<Integer>,
MutableGidEntity<String>,
MutableDescriptionEntity<String> {

}
