package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.base.bean.projections.ArtistVirtualProjection;
import org.nanotek.beans.entity.Artist;
import org.nanotek.repository.jpa.ArtistRepository;
import org.nanotek.repository.jpa.projections.ArtistBaseProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

//TODO: Create support for ExampleMathcers
@Service
@Validated
public class ArtistJpaService extends BasePersistenceService<Artist,Long> {

	private static final long serialVersionUID = 4661067648228104876L;
	
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	ArtistBaseProjection baseProjection;
	

	@Transactional
	public Artist save(Artist Artist) { 
		return artistRepository.save(Artist);
	}
	
	@Transactional
	public List<Artist> saveAll(List<Artist> list) { 
		return artistRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<Artist> findById(Long k) {
		return artistRepository.findById(k);
	}
	
	@Transactional
	public  Optional<Artist> findOne(Example<Artist> example) {
		return artistRepository.findOne(example);
	}
	
	@Transactional
	public  Optional<Artist> findByArtistId(Long artistId) {
		return artistRepository.findByArtistId(artistId);
	}
	
	@Transactional
	public Iterable<Artist> findByNameContaining(@NotNull @NotEmpty String name){ 
		return artistRepository.findByNameContainingIgnoreCase(name);
	}
	
	@Transactional
	public Optional<ArtistVirtualProjection> projectArtistVirtualByArtistId(Long artistId){ 
		return baseProjection.findByArtistId(artistId);
	}
	
}
