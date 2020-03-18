package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.RecordingIdEntity;

public interface MutableRecordingIdEntity<K extends Serializable> extends RecordingIdEntity<K>{

	void setRecordingId(K k);
	
}
