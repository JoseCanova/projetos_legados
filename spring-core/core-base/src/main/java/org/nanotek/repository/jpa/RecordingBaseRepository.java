package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.RecordBase;

public interface RecordingBaseRepository<K extends RecordBase<?>, ID extends Serializable> {
	Optional<RecordBase<ID>> findByRecordingId(@NotNull ID recordingId);
}
