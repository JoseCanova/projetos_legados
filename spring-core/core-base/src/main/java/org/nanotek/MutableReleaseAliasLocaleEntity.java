package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseAliasLocaleEntity<K extends Serializable> extends ReleaseAliasLocaleEntity<K>{
	void setReleaseAliasLocale(K k);
}
