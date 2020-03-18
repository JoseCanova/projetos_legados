package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableRecordingIdEntity;

public interface RecordingBaseRepository<K extends MutableRecordingIdEntity<?>, ID extends Serializable> {
	Optional<MutableRecordingIdEntity<ID>> findByRecordingId(@NotNull ID recordingId);
}
