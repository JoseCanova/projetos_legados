package org.nanotek.service;

import java.util.Optional;

public interface BaseService<O  , K> {
	 Optional<O> findById(K k );
}
