package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Instrument;
import org.nanotek.beans.entity.InstrumentComment;
import org.nanotek.beans.entity.InstrumentDescription;
import org.nanotek.repository.jpa.InstrumentCommentRepository;
import org.nanotek.repository.jpa.InstrumentDescriptionRepository;
import org.nanotek.repository.jpa.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class InstrumentJpaService extends BasePersistenceService<Instrument, Long> {

	private static final long serialVersionUID = -7591226004082620481L;
	
	@Autowired
	InstrumentRepository repository;
	
	@Autowired
	InstrumentCommentRepository commentRepository;
	
	@Autowired
	InstrumentDescriptionRepository descriptionRepository;
	
	@Override
	@Transactional
	public Optional<Instrument> findById(Long k) {
		return repository.findById(k);
	}
	
	@Transactional
	public Optional<Instrument> findByInstrumentId(@Validated @Valid @NotNull Long instrumentId){ 
		return repository.findByInstrumentId(instrumentId);
	}
	
	@Transactional
	public Instrument save(@Validated @Valid @NotNull Instrument bean) { 
		return repository.save(bean);
	}

	public <S extends Instrument> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<Instrument> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<Instrument> findAll() {
		return repository.findAll();
	}

	public List<Instrument> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<Instrument> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	public <S extends Instrument> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends Instrument> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<Instrument> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends Instrument> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public Instrument getOne(Long id) {
		return repository.getOne(id);
	}

	public <S extends Instrument> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends Instrument> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends Instrument> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public <S extends Instrument> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(Instrument entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Instrument> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	@Transactional
	public InstrumentComment saveComment(@Validated @Valid @NotBlank InstrumentComment entity) { 
		return commentRepository.save(entity);
	}
	
	@Transactional
	public InstrumentDescription saveDescription(@Validated @Valid @NotBlank InstrumentDescription entity) { 
		return descriptionRepository.save(entity);
	}
}
