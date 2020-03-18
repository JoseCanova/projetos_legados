package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ReleaseAliasLocaleEntity;

public interface MutableReleaseAliasLocaleEntity<K extends Serializable> extends ReleaseAliasLocaleEntity<K>{
	void setReleaseAliasLocale(K k);
}