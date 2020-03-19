package org.nanotek.service;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.ArtistCreditName;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.nanotek.service.jpa.ArtistCreditNameJpaService;
import org.nanotek.service.jpa.ArtistJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistService {

	@Autowired
	private ArtistJpaService<?> artistJpaService;

	@Autowired 
	private ArtistCreditJpaService<?> artistCreditJpaService;
	
	@Autowired
	private ArtistCreditNameJpaService<?> artistCreditNameJpaService;
	
	@Transactional
	public Optional<?> findArtistById(Long id){ 
		return artistJpaService.findById(id);
	}
	
	@Transactional
	public Optional<?> findArtistCreditById(Long id){ 
		return artistCreditJpaService.findById(id);
	}
	
	@Transactional
	public Optional<?> findArtistCreditNameById(Long id){ 
		return artistCreditNameJpaService.findById(id);
	}
	
	@Transactional 
	public ArtistCreditName<?> saveArtistCreditName(ArtistCreditName<?> val) { 
		return artistCreditNameJpaService.save(val);
	}
	
	@Transactional 
	public <K extends ArtistCredit<K>> Optional<K> findByArtistCreditId(Long id) { 
		Optional<ArtistCredit> artistCredit = artistCreditJpaService.findById(id);
		return artistCredit;
	}

	@Transactional 
	public Optional<Artist> findByArtistId(Long artistId) {
		return artistJpaService.findByArtistId(artistId);
	}
	
	@Transactional
	public Iterable<Artist> findByNameLike(@NotNull @NotEmpty  String name){ 
		return artistJpaService.findByNameContaining(name);
	}
}
