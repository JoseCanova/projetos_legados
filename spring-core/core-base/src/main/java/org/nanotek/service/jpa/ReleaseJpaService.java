package org.nanotek.service.jpa;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Release;
import org.nanotek.repository.jpa.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ReleaseJpaService {

	@Autowired
	private ReleaseRepository repository; 
	
	@Transactional
	public Release save (Release release) { 
		return repository.save(release);
	}
	
	@Transactional
	public Optional<Release> findById(@Validated @Valid @NotNull Long id){ 
		return repository.findById(id);
	}
	
	@Transactional
	public Optional<Release> findByReleaseId(@Validated @Valid @NotNull Long releaseId){ 
		return repository.findByReleaseId(releaseId);
	}
}
