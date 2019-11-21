package org.nanotek.service.jpa;

import java.util.List;

import org.nanotek.beans.ArtistName;
import org.nanotek.repository.ArtistNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistNameJpaService {


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
}
