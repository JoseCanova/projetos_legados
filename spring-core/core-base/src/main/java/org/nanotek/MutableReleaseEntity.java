package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseEntity<K extends Serializable> extends ReleaseEntity<K>{

	void setRelease(K k);
	
}
