package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseAliasBeginDateEntity<K extends Serializable> extends ReleaseAliasBeginDateEntity<K>{

	void setReleaseAliasBeginDateEntity(K k);
	
}
