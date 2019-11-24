package org.nanotek.service;

import java.util.Optional;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.ArtistName;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.nanotek.service.jpa.ArtistCreditNameJpaService;
import org.nanotek.service.jpa.ArtistNameJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistService{

	@Autowired
	private ArtistNameJpaService artistNameJpaService;

	@Autowired 
	private ArtistCreditJpaService artistCreditJpaService;
	
	@Autowired
	private ArtistCreditNameJpaService artistCreditNameJpaService;
	
	@Transactional
	public Optional<ArtistName> findArtistNameById(Long id){ 
		return artistNameJpaService.findById(id);
	}
	
	@Transactional
	public Optional<ArtistCredit> findArtistCreditById(Long id){ 
		return artistCreditJpaService.findById(id);
	}
	
	@Transactional
	public Optional<ArtistCreditName> findArtistCreditNameById(Long id){ 
		return artistCreditNameJpaService.findById(id);
	}
	
	@Transactional 
	public ArtistCreditName saveArtistCreditName(ArtistCreditName val) { 
		return artistCreditNameJpaService.save(val);
	}
	
	@Transactional 
	public Optional<ArtistCredit> findByArtistCreditId(Long id) { 
		Optional<ArtistCredit> artistCredit = artistCreditJpaService.findByArtistCreditId(id);
		return artistCredit;
	}

	public Optional<ArtistName> findByArtistId(Long artistId) {
		return artistNameJpaService.findByArtistId(artistId);
	}
}
