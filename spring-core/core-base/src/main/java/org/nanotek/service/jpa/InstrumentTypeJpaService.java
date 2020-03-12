package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.InstrumentComment;
import org.nanotek.beans.entity.InstrumentType;
import org.nanotek.repository.jpa.InstrumentCommentRepository;
import org.nanotek.repository.jpa.InstrumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class InstrumentTypeJpaService extends BasePersistenceService<InstrumentType, Long> {

	
	private static final long serialVersionUID = 753700785985875965L;
	
	@Autowired
	InstrumentTypeRepository repository;
	
	@Override
	@Transactional
	public Optional<InstrumentType> findById(Long k) {
		return repository.findById(k);
	}
	
	@Transactional
	public InstrumentType save(@Validated @Valid @NotNull InstrumentType bean) { 
		return repository.save(bean);
	}
	
	@Transactional
	public  Optional<InstrumentType> findOne(Example<InstrumentType> example) {
		return repository.findOne(example);
	}
	
	@Transactional
	public Iterable<InstrumentType> findByNameContaining(@Validated @Valid @NotBlank  String name){ 
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Iterable<InstrumentType> findByNameContainingIgnoreCase(@Validated @Valid @NotNull String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

	@Transactional
	public Optional<InstrumentType> findByTypeId(@Validated @Valid @NotNull Long typeId) {
		return repository.findByTypeId(typeId);
	}

	public Page<InstrumentType> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<InstrumentType> findAll() {
		return repository.findAll();
	}

	public List<InstrumentType> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<InstrumentType> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	public <S extends InstrumentType> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends InstrumentType> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<InstrumentType> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends InstrumentType> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public InstrumentType getOne(Long id) {
		return repository.getOne(id);
	}

	public <S extends InstrumentType> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends InstrumentType> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends InstrumentType> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public <S extends InstrumentType> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(InstrumentType entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends InstrumentType> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
	
}
