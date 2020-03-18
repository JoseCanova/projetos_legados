package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseAliasIdEntity<K extends Serializable> extends ReleaseAliasIdEntity<K>{

	void setReleaseAliasId(K k);
	
}
