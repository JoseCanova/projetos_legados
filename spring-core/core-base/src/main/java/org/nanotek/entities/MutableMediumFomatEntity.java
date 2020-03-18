package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.beans.entity.MutableNameEntity;

public interface MutableMediumFomatEntity<K extends Serializable> extends 
MutableNameEntity<String>,
MutableParentEntity<Long>,
MutableYearEntity<Integer>,
MutableGidEntity<String>,
MutableDescriptionEntity<String> {

}
