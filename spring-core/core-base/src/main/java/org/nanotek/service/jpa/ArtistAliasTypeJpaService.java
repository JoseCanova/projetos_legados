package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.ArtistAliasType;
import org.nanotek.repository.jpa.ArtistAliasTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ArtistAliasTypeJpaService extends BasePersistenceService<ArtistAliasType, Long> {

	private static final long serialVersionUID = -998811478796345037L;
	
	@Autowired
	ArtistAliasTypeRepository repository;

	public Iterable<ArtistAliasType> findByNameContainingIgnoreCase(@NotNull String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Optional<ArtistAliasType> findByTypeId(@NotNull Long typeId) {
		return repository.findByTypeId(typeId);
	}

	public <S extends ArtistAliasType> S save(S entity) {
		return repository.save(entity);
	}

	public <S extends ArtistAliasType> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<ArtistAliasType> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<ArtistAliasType> findAll() {
		return repository.findAll();
	}

	public List<ArtistAliasType> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<ArtistAliasType> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	public <S extends ArtistAliasType> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public Optional<ArtistAliasType> findById(Long id) {
		return repository.findById(id);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends ArtistAliasType> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<ArtistAliasType> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends ArtistAliasType> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public ArtistAliasType getOne(Long id) {
		return repository.getOne(id);
	}

	public <S extends ArtistAliasType> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends ArtistAliasType> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends ArtistAliasType> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public <S extends ArtistAliasType> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(ArtistAliasType entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends ArtistAliasType> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
	
	
	
}
