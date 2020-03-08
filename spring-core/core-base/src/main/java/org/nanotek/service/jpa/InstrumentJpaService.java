package org.nanotek.service.jpa;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Instrument;
import org.nanotek.repository.jpa.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentJpaService extends BasePersistenceService<Instrument, Long> {

	private static final long serialVersionUID = -7591226004082620481L;
	
	@Autowired
	InstrumentRepository repository;
	
	@Override
	@Transactional
	public Optional<Instrument> findById(Long k) {
		return repository.findById(k);
	}
	
	@Transactional
	public Optional<Instrument> findByInstrumentId(@NotNull Long instrumentId){ 
		return repository.findByInstrumentId(instrumentId);
	}
	
	@Transactional
	public Instrument save(Instrument bean) { 
		return repository.save(bean);
	}

}
