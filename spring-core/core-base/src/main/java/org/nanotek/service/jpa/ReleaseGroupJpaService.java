package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ReleaseGroup;
import org.nanotek.repository.jpa.ReleaseGroupRepository;
import org.nanotek.service.LongIdGidNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseGroupJpaService  extends LongIdGidNameEntityService<ReleaseGroup,ReleaseGroupRepository> {

	public ReleaseGroupJpaService(@Autowired ReleaseGroupRepository rep) {
		super(rep);
	}

	public Optional<ReleaseGroup> findByReleaseGrouId(Long releaseGroupId){
		return baseRepository.findByReleaseGroupId(releaseGroupId);
	}

}
