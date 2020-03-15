package org.nanotek.repository.jpa;

import java.util.Optional;

import org.nanotek.RecordingAliasIdBase;
import org.nanotek.beans.entity.RecordingAlias;

public interface RecordingAliasIdBaseRepository extends LongIdNameEntityRepository<RecordingAlias> {
	Optional<RecordingAliasIdBase<Long>> findByRecordingAliasId(Long recordingAliasId);
}
