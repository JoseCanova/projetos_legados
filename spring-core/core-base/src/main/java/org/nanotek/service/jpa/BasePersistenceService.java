package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.beans.entity.SequenceLongBase;
import org.nanotek.repository.jpa.SequenceLongBaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public abstract class BasePersistenceService<B extends SequenceLongBase<B,Long>, R extends SequenceLongBaseRepository<R,B>>  {

	protected R  baseRepository;
	
	public BasePersistenceService() {
		super();
	}

	public BasePersistenceService(R baseRepository) {
		super();
		this.baseRepository = baseRepository;
	}


	public List<B> findAll() {
		return baseRepository.findAll();
	}

	
	public List<B> findAll(Sort sort) {
		return baseRepository.findAll(sort);
	}

	
	public List<B> findAllById(Iterable<Long> ids) {
		return baseRepository.findAllById(ids);
	}

	
	public  List<B> saveAll(Iterable<B> entities) {
		return baseRepository.saveAll(entities);
	}

	
	public void flush() {
		baseRepository.flush();
	}

	
	public  B saveAndFlush(B entity) {
		return baseRepository.saveAndFlush(entity);
	}

	
	public void deleteInBatch(Iterable<B> entities) {
		baseRepository.deleteInBatch(entities);
	}

	
	public void deleteAllInBatch() {
		baseRepository.deleteAllInBatch();
	}

	
	public  List<B> findAll(Example<B> example) {
		return baseRepository.findAll(example);
	}

	
	public  List<B> findAll(Example<B> example, Sort sort) {
		return findAll(example,sort);
	}

	public  B save(B entity) {
		return baseRepository.save(entity);
	}

	public  Optional<B> findOne(Example<B> example) {
		return baseRepository.findOne(example);
	}

	public Page<B> findAll(Pageable pageable) {
		return baseRepository.findAll(pageable);
	}

	public Optional<B> findById(Long id) {
		return baseRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return baseRepository.existsById(id);
	}

	public  Page<B> findAll(Example<B> example, Pageable pageable) {
		return baseRepository.findAll(example, pageable);
	}

	public B getOne(Long id) {
		return baseRepository.getOne(id);
	}

	public  long count(Example<B> example) {
		return baseRepository.count(example);
	}

	public  boolean exists(Example<B> example) {
		return baseRepository.exists(example);
	}

	public long count() {
		return baseRepository.count();
	}

	public void deleteById(Long id) {
		baseRepository.deleteById(id);
	}

	public void delete(B entity) {
		baseRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends B> entities) {
		baseRepository.deleteAll(entities);
	}

	public void deleteAll() {
		baseRepository.deleteAll();
	}
	
	

}
