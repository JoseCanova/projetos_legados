package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ReleaseAliasTypeEntity;

public interface MutableReleaseAliasTypeEntity<K extends Serializable> extends ReleaseAliasTypeEntity<K>{
		void setReleaseAliasType(K k);
}
