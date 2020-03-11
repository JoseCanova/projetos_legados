package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistAlias;
import org.nanotek.repository.jpa.ArtistAliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ArtistAliasJpaService   extends BasePersistenceService<ArtistAlias,Long>{

	private static final long serialVersionUID = -7411034786169898420L;
	
	@Autowired
	ArtistAliasRepository repository;
	
	public ArtistAliasJpaService() {
	}

	public Iterable<ArtistAlias> findByNameContainingIgnoreCase(@NotNull String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Optional<ArtistAlias> findByAliasId(@NotNull Long aliasId) {
		return repository.findByAliasId(aliasId);
	}

	public <S extends ArtistAlias> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends ArtistAlias> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<ArtistAlias> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<ArtistAlias> findAll() {
		return repository.findAll();
	}

	public List<ArtistAlias> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<ArtistAlias> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	public <S extends ArtistAlias> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public Optional<ArtistAlias> findById(Long id) {
		return repository.findById(id);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends ArtistAlias> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<ArtistAlias> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends ArtistAlias> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public ArtistAlias getOne(Long id) {
		return repository.getOne(id);
	}

	public <S extends ArtistAlias> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends ArtistAlias> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends ArtistAlias> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public <S extends ArtistAlias> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(ArtistAlias entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends ArtistAlias> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	
	
}
