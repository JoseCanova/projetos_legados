package org.nanotek;

import java.io.Serializable;

public interface RecordingIdEntity<K extends Serializable> {
	K getRecordingId();
}
