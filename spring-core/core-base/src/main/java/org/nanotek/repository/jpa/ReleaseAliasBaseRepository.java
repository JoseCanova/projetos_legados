package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.ReleaseAliasBase;

public interface ReleaseAliasBaseRepository<K extends ReleaseAliasBase<ID>, ID extends Serializable> {

	Optional<K> findByReleaseAliasId(ID id);
	
}
