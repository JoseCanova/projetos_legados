package org.nanotek.repository.jpa;

import java.util.Optional;

import org.nanotek.RecordingAliasIdBase;
import org.nanotek.beans.entity.RecordingAlias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingAliasIdBaseRepository extends JpaRepository<RecordingAlias,Long> {
	Optional<RecordingAliasIdBase<Long>> findByRecordingAliasId(Long recordingAliasId);
}
