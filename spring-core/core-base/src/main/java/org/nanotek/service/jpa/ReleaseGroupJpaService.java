package org.nanotek.service.jpa;

import java.util.Optional;

import org.nanotek.beans.entity.ReleaseGroup;
import org.nanotek.repository.jpa.ReleaseGroupJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReleaseGroupJpaService  extends BasePersistenceService<ReleaseGroup,Long> {

	private static final long serialVersionUID = -2685317051279601491L;
	
	@Autowired
	ReleaseGroupJpaRepository rep; 
	
	public ReleaseGroupJpaService() {
	}

	@Override
	@Transactional
	public Optional<ReleaseGroup> findById(Long k) {
		return rep.findById(k);
	}
	
	@Transactional
	public ReleaseGroup save (ReleaseGroup group) { 
		return rep.save(group);
	}

}
