package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.IdBase;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class BasePersistenceService<O extends IdBase<?,Long>, R extends IdBaseRepository<O>>  {

	protected R  baseRepository;
	
	public BasePersistenceService() {
		super();
	}

	public BasePersistenceService(R baseRepository) {
		super();
		this.baseRepository = baseRepository;
	}


	public List<O> findAll() {
		return baseRepository.findAll();
	}

	
	public List<O> findAll(Sort sort) {
		return baseRepository.findAll(sort);
	}

	
	public List<O> findAllById(Iterable<Long> ids) {
		return baseRepository.findAllById(ids);
	}

	
	public  List<O> saveAll(Iterable<O> entities) {
		return baseRepository.saveAll(entities);
	}

	
	public void flush() {
		baseRepository.flush();
	}

	
	public  O saveAndFlush(O entity) {
		return baseRepository.saveAndFlush(entity);
	}

	
	public void deleteInBatch(Iterable<O> entities) {
		baseRepository.deleteInBatch(entities);
	}

	
	public void deleteAllInBatch() {
		baseRepository.deleteAllInBatch();
	}

	
	public  List<O> findAll(Example<O> example) {
		return baseRepository.findAll(example);
	}

	
	public  List<O> findAll(Example<O> example, Sort sort) {
		return findAll(example,sort);
	}

	public  O save(O entity) {
		return baseRepository.save(entity);
	}

	public  Optional<O> findOne(Example<O> example) {
		return baseRepository.findOne(example);
	}

	public Page<O> findAll(Pageable pageable) {
		return baseRepository.findAll(pageable);
	}

	public Optional<O> findById(Long id) {
		return baseRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return baseRepository.existsById(id);
	}

	public  Page<O> findAll(Example<O> example, Pageable pageable) {
		return baseRepository.findAll(example, pageable);
	}

	public O getOne(Long id) {
		return baseRepository.getOne(id);
	}

	public  long count(Example<O> example) {
		return baseRepository.count(example);
	}

	public  boolean exists(Example<O> example) {
		return baseRepository.exists(example);
	}

	public long count() {
		return baseRepository.count();
	}

	public void deleteById(Long id) {
		baseRepository.deleteById(id);
	}

	public void delete(O entity) {
		baseRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends O> entities) {
		baseRepository.deleteAll(entities);
	}

	public void deleteAll() {
		baseRepository.deleteAll();
	}
	
	

}
