package org.nanotek.service.jpa;

import java.io.Serializable;
import java.util.List;

import org.nanotek.Base;
import org.nanotek.service.BaseService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

@SuppressWarnings("serial")
public abstract class BasePersistenceService<O extends Base, K extends Serializable> implements BaseService<O,K>{

	@Override
	public List<O> findAll() {
		return null;
	}

	@Override
	public List<O> findAll(Sort sort) {
		return null;
	}

	@Override
	public List<O> findAllById(Iterable<Long> ids) {
		return null;
	}

	@Override
	public <S extends O> List<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {
	}

	@Override
	public <S extends O> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<O> entities) {
	}

	@Override
	public void deleteAllInBatch() {
	}

	@Override
	public O getOne(Long id) {
		return null;
	}

	@Override
	public <S extends O> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends O> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

}
