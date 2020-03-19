package org.nanotek.service.jpa;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Instrument;
import org.nanotek.beans.entity.InstrumentComment;
import org.nanotek.beans.entity.InstrumentDescription;
import org.nanotek.repository.jpa.InstrumentCommentRepository;
import org.nanotek.repository.jpa.InstrumentDescriptionRepository;
import org.nanotek.repository.jpa.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class InstrumentJpaService<K extends Instrument<K>, C extends InstrumentComment<C>> 
extends BasePersistenceService<K , InstrumentRepository<K>> {

	
	@Autowired
	InstrumentCommentRepository<C> commentRepository;
	
	//TODO: verify why description is not generic.
	@Autowired
	InstrumentDescriptionRepository<InstrumentDescription> descriptionRepository;
	
	public InstrumentJpaService() {
		super();
	}

	public InstrumentJpaService(@Autowired InstrumentRepository<K> baseRepository) {
		super(baseRepository);
	}

	@Transactional
	public Optional<K> findByInstrumentId(@Validated @Valid @NotNull Long instrumentId){ 
		return baseRepository.findByInstrumentId(instrumentId);
	}
	
	@Transactional
	public C saveComment(@Validated @Valid @NotBlank C entity) { 
		return commentRepository.save(entity);
	}
	
	@Transactional
	public InstrumentDescription saveDescription(@Validated @Valid @NotBlank InstrumentDescription entity) { 
		return descriptionRepository.save(entity);
	}
}
