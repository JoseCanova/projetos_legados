package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Recording;
import org.nanotek.repository.jpa.RecordingRepository;
import org.nanotek.service.LongIdGidNameEntityService;
import org.springframework.stereotype.Service;

@Service
public class RecordingJpaService extends LongIdGidNameEntityService<Recording, RecordingRepository>{

	public RecordingJpaService(RecordingRepository rep) {
		super(rep);
	}

//	@Override
//	@Transactional
////	@Cacheable(cacheNames="recordings", key="#k")
//	public Optional<Recording> findById(Long k) {
//		return recordingRepository.findById(k);
//	}
	
}
