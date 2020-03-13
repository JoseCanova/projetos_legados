package org.nanotek;

import java.io.Serializable;

public interface ReleaseGroupBase<K extends Serializable> {

	K getReleaseGroupId();
	
	void setReleaseGroupId(K k);
}
