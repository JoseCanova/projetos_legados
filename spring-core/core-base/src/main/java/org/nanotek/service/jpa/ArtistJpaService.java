package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.Artist;
import org.nanotek.repository.jpa.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

//TODO: Create support for ExampleMathcers
@Service
@Validated
public class ArtistJpaService extends BasePersistenceService<Artist,Long> {

	@Autowired
	private ArtistRepository ArtistRepository;

	@Transactional
	public Artist save(Artist Artist) { 
		return ArtistRepository.save(Artist);
	}
	
	@Transactional
	public List<Artist> saveAll(List<Artist> list) { 
		return ArtistRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<Artist> findById(Long k) {
		return ArtistRepository.findById(k);
	}
	
	@Transactional
	public  Optional<Artist> findOne(Example<Artist> example) {
		return ArtistRepository.findOne(example);
	}
	
	@Transactional
	public  List<Artist> findByArtistId(Long artistId) {
		return ArtistRepository.findByArtistId(artistId);
	}
	
	@Transactional
	public List<Artist> findByNameContaining(@NotNull @NotEmpty String name){ 
		return ArtistRepository.findByNameEspec(name.toUpperCase());
//		return ArtistRepository.findByNameContainingIgnoreCase(name.toUpperCase());
	}
	
}
