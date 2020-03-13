package org.nanotek;

import java.io.Serializable;

public interface RecordBase<K extends Serializable> {

	K getRecordingId();
	
	void setRecordingId(K k);
	
}
