package org.nanotek.beans.entity;

import java.io.Serializable;

public interface ReleaseBase<K extends Serializable> {

	K getReleaseId();
	
	void setReleaseId(K k);
	
}
