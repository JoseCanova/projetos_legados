package org.nanotek;

import java.io.Serializable;

public interface MutableRecordingIdEntity<K extends Serializable> extends RecordingIdEntity<K>{

	void setRecordingId(K k);
	
}
