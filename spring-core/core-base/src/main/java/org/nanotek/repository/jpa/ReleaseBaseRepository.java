package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ReleaseBase;

public interface ReleaseBaseRepository<T extends ReleaseBase<ID> , ID extends Serializable> {
	Optional<T> findByReleaseId(@NotNull ID releaseId);
}
