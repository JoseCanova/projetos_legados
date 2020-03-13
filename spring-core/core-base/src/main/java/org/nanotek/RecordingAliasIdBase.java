package org.nanotek;

import javax.validation.constraints.NotNull;

public interface RecordingAliasIdBase<K> {
	
	K getRecordingAliasId();
	
	void setRecordingAliasId(@NotNull K id);

}
