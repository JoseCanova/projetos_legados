package org.nanotek.service;

import java.util.Optional;

import org.hibernate.service.Service;

@FunctionalInterface
public interface BaseService<O  , K> extends Service {
	 Optional<O> findById(K k );
}
