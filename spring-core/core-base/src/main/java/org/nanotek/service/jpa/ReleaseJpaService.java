package org.nanotek.service.jpa;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Release;
import org.nanotek.repository.jpa.ReleaseRepository;
import org.nanotek.service.LongIdGidNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ReleaseJpaService extends LongIdGidNameEntityService<Release , ReleaseRepository>{

	public ReleaseJpaService(@Autowired ReleaseRepository rep) {
		super(rep);
	}

	@Transactional
	public Optional<Release> findByReleaseId(@Validated @Valid @NotNull Long releaseId){ 
		return baseRepository.findByReleaseId(releaseId);
	}
}
