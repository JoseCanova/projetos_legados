package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.ArtistName;
import org.nanotek.repository.ArtistNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

//TODO: Create support for ExampleMathcers
@Service
@Validated
public class ArtistNameJpaService extends BasePersistenceService<ArtistName,Long> {

	@Autowired
	private ArtistNameRepository artistNameRepository;

	@Transactional
	public ArtistName save(ArtistName artistName) { 
		return artistNameRepository.save(artistName);
	}
	
	@Transactional
	public List<ArtistName> saveAll(List<ArtistName> list) { 
		return artistNameRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<ArtistName> findById(Long k) {
		return artistNameRepository.findById(k);
	}
	
	@Transactional
	public  Optional<ArtistName> findOne(Example<ArtistName> example) {
		return artistNameRepository.findOne(example);
	}
	
	@Transactional
	public  List<ArtistName> findByArtistId(Long artistId) {
		return artistNameRepository.findByArtistId(artistId);
	}
	
	@Transactional
	public List<ArtistName> findByNameContaining(@NotNull @NotEmpty String name){ 
		return artistNameRepository.findByNameContainingIgnoreCase(name.toUpperCase());
	}
	
}
