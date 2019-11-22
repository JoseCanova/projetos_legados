package org.nanotek.service.jpa;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public abstract class BasePersistenceService<O extends Base<K>, K extends Serializable> implements BaseService<O>{
	public abstract  Optional<O> findById(K k );
}
