package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.ReleaseGroupBase;

public interface ReleaseGroupBaseRepository<K extends ReleaseGroupBase<ID>, ID extends Serializable> {

	Optional<K> findByReleaseGroupId(@NotNull ID releaseGroupId);
	
}
