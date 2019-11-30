package org.nanotek.service.jpa;

import org.nanotek.beans.Recording;
import org.nanotek.repository.RecordingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordingJpaService {

	@Autowired
	private RecordingRepository recordingRepository;
	
	@Transactional
	public Recording save(Recording recording) { 
		return recordingRepository.save(recording);
	}
	
}
