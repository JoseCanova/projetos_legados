package org.nanotek.beans.entity;

import java.io.Serializable;

import org.nanotek.LongIdNameGidEntityBase;

public interface BaseTypeEntityBase<K extends BaseType, ID extends Serializable>  extends   LongIdNameGidEntityBase<String, String> {
	
	
	@Override
	default BaseTypeEntityBase<K ,ID> get() {
		return this;
	}
}
