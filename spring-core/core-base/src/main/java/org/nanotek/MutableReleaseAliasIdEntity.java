package org.nanotek;

import java.io.Serializable;

public interface ReleaseAliasBase<K extends Serializable> {

	K getReleaseAliasId();
	
	void setReleaseAliasId(K k);
	
}
