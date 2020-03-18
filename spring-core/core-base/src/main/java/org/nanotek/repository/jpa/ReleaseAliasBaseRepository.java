package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.entities.MutableReleaseAliasIdEntity;

public interface ReleaseAliasBaseRepository<K extends MutableReleaseAliasIdEntity<ID>, ID extends Serializable> {

	Optional<K> findByReleaseAliasId(ID id);
	
}
