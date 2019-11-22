package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.ArtistName;
import org.nanotek.repository.ArtistNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.transaction.annotation.Transactional;

//TODO: Create support for ExampleMathcers
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
}
