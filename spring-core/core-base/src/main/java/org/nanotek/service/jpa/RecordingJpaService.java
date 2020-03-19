package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Recording;
import org.nanotek.repository.jpa.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordingJpaService<K extends Recording<K>> {

	@Autowired
	RecordingRepository<K> rep;
	
	public RecordingJpaService() {
		super();
	}

//	@Override
//	@Transactional
////	@Cacheable(cacheNames="recordings", key="#k")
//	public Optional<Recording> findById(Long k) {
//		return recordingRepository.findById(k);
//	}
	
}
