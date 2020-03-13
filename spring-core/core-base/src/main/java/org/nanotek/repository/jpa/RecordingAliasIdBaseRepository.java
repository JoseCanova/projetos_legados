package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.RecordingAlias;

import java.util.Optional;

import org.nanotek.RecordingAliasIdBase;

public interface RecordingAliasIdBaseRepository extends LongIdNameEntityRepository<RecordingAlias> {
	Optional<RecordingAliasIdBase<Long>> findByRecordingAliasId(Long recordingAliasId);
}
