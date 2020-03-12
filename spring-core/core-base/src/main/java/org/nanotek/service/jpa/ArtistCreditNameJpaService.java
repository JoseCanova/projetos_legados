package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.entity.ArtistCreditName;
import org.nanotek.repository.jpa.ArtistCreditNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistCreditNameJpaService extends BasePersistenceService<ArtistCreditName , Long> {

	private static final long serialVersionUID = 7611202335217358327L;
	
	@Autowired
	private ArtistCreditNameRepository repository;
	
	
	@Transactional
	public ArtistCreditName save(ArtistCreditName a) { 
		   return repository.save(a);
	}
	
	@Transactional
	public Optional<ArtistCreditName> findById(Long id) { 
		return  repository.findById(id);
	}
	
	@Transactional
	public List<ArtistCreditName> findByArtistCreditId(Long id){ 
		return repository.findByArtistCreditId(id);
	}

	public <S extends ArtistCreditName> Optional<S> findOne(Example<S> example) {
		return repository.findOne(example);
	}

	public Page<ArtistCreditName> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<ArtistCreditName> findAll() {
		return repository.findAll();
	}

	public List<ArtistCreditName> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<ArtistCreditName> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	public <S extends ArtistCreditName> List<S> saveAll(Iterable<S> entities) {
		return repository.saveAll(entities);
	}

	public void flush() {
		repository.flush();
	}

	public <S extends ArtistCreditName> S saveAndFlush(S entity) {
		return repository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void deleteInBatch(Iterable<ArtistCreditName> entities) {
		repository.deleteInBatch(entities);
	}

	public <S extends ArtistCreditName> Page<S> findAll(Example<S> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public ArtistCreditName getOne(Long id) {
		return repository.getOne(id);
	}

	public <S extends ArtistCreditName> long count(Example<S> example) {
		return repository.count(example);
	}

	public <S extends ArtistCreditName> boolean exists(Example<S> example) {
		return repository.exists(example);
	}

	public <S extends ArtistCreditName> List<S> findAll(Example<S> example) {
		return repository.findAll(example);
	}

	public long count() {
		return repository.count();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public <S extends ArtistCreditName> List<S> findAll(Example<S> example, Sort sort) {
		return repository.findAll(example, sort);
	}

	public void delete(ArtistCreditName entity) {
		repository.delete(entity);
	}

	public void deleteAll(Iterable<? extends ArtistCreditName> entities) {
		repository.deleteAll(entities);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

}
