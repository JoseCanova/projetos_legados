package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ReleaseAliasBeginDateEntity;

public interface MutableReleaseAliasBeginDateEntity<K extends Serializable> extends ReleaseAliasBeginDateEntity<K>{

	void setReleaseAliasBeginDateEntity(K k);
	
}
