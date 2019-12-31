package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.Recording;
import org.nanotek.repository.jpa.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordingJpaService extends BasePersistenceService<Recording , Long>{

	@Autowired
	private RecordingRepository recordingRepository;
	
	@Transactional
	public Recording save(Recording recording) { 
		return recordingRepository.save(recording);
	}

	@Override
	@Transactional
	public Optional<Recording> findById(Long k) {
		return recordingRepository.findById(k);
	}
	
}
