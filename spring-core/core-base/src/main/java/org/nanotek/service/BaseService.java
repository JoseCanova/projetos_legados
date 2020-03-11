package org.nanotek.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.service.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;

public interface BaseService<O  , K> extends Service {
	
	@Validated(value = Default.class)
	Optional<O> findById(@NotNull K k );
	
	List<O> findAll();

	
	List<O> findAll(Sort sort);

	
	List<O> findAllById(Iterable<Long> ids);

	
	<S extends O> List<S> saveAll(Iterable<S> entities);

	void flush();

	<S extends O> S saveAndFlush(S entity);

	void deleteInBatch(Iterable<O> entities);

	void deleteAllInBatch();

	O getOne(Long id);

	
	<S extends O> List<S> findAll(Example<S> example);

	
	<S extends O> List<S> findAll(Example<S> example, Sort sort);
}
