package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Instrument;
import org.nanotek.beans.entity.InstrumentComment;
import org.nanotek.beans.entity.InstrumentDescription;
import org.nanotek.repository.jpa.IdBaseRepository;
import org.nanotek.repository.jpa.InstrumentCommentRepository;
import org.nanotek.repository.jpa.InstrumentDescriptionRepository;
import org.nanotek.repository.jpa.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class InstrumentJpaService extends BasePersistenceService<Instrument , InstrumentRepository> {

	
	@Autowired
	InstrumentCommentRepository commentRepository;
	
	@Autowired
	InstrumentDescriptionRepository<InstrumentDescription> descriptionRepository;
	
	public InstrumentJpaService() {
		super();
	}

	public InstrumentJpaService(@Autowired InstrumentRepository baseRepository) {
		super(baseRepository);
	}

	@Transactional
	public Optional<Instrument> findByInstrumentId(@Validated @Valid @NotNull Long instrumentId){ 
		return baseRepository.findByInstrumentId(instrumentId);
	}
	
	@Transactional
	public InstrumentComment saveComment(@Validated @Valid @NotBlank InstrumentComment entity) { 
		return commentRepository.save(entity);
	}
	
	@Transactional
	public InstrumentDescription saveDescription(@Validated @Valid @NotBlank InstrumentDescription entity) { 
		return descriptionRepository.save(entity);
	}
}
