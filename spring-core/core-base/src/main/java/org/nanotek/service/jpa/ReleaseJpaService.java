package org.nanotek.service.jpa;

import org.nanotek.beans.Release;
import org.nanotek.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReleaseJpaService {

	@Autowired
	private ReleaseRepository repository; 
	
	
	@Transactional
	public Release save (Release release) { 
		return repository.save(release);
	}
	
	
}
