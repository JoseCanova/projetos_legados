package org.nanotek.repository.jpa;

import java.util.Optional;

import org.nanotek.MutableRecordingAliasIdEntity;
import org.nanotek.beans.entity.RecordingAlias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingAliasIdBaseRepository extends JpaRepository<RecordingAlias,Long> {
	Optional<MutableRecordingAliasIdEntity<Long>> findByRecordingAliasId(Long recordingAliasId);
}
