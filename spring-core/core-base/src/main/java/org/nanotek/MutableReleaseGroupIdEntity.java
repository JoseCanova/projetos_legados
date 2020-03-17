package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseGroupIdEntity<K extends Serializable> extends ReleaseGroupIdEntity<K> {

	

	
	void setReleaseGroupId(K k);
}
