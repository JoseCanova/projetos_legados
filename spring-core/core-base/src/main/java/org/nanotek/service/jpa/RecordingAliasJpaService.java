package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.entity.RecordingAlias;
import org.nanotek.repository.jpa.RecordingAliasJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordingAliasJpaService extends BasePersistenceService<RecordingAlias,Long> {

	
	private static final long serialVersionUID = 3981415001124728653L;
	
	
	@Autowired
	private RecordingAliasJpaRepository recordingRepository;
	

	@Transactional
	public RecordingAlias save(RecordingAlias RecordingAlias) { 
		return recordingRepository.save(RecordingAlias);
	}
	
	@Transactional
	public List<RecordingAlias> saveAll(List<RecordingAlias> list) { 
		return recordingRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<RecordingAlias> findById(Long k) {
		return recordingRepository.findById(k);
	}
	
	@Transactional
	public  Optional<RecordingAlias> findOne(Example<RecordingAlias> example) {
		return recordingRepository.findOne(example);
	}

}
