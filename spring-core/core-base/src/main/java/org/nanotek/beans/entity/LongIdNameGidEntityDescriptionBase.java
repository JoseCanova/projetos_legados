package org.nanotek.beans.entity;

import java.io.Serializable;

import org.nanotek.LongIdNameGidEntityBase;

public interface LongIdNameGidEntityDescriptionBase<T1 extends Serializable, T2 extends Serializable, T3 extends Serializable> extends LongIdNameGidEntityBase<T2, T3> {

	T1 getDescription();
	
}
