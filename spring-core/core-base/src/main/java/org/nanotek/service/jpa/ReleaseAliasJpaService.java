package org.nanotek.service.jpa;

import java.util.List;
import java.util.Optional;

import org.nanotek.beans.entity.ReleaseAlias;
import org.nanotek.repository.jpa.ReleaseAliasJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReleaseAliasJpaService extends BasePersistenceService<ReleaseAlias,Long> {

	
	private static final long serialVersionUID = 3981415001124728653L;
	
	
	@Autowired
	private ReleaseAliasJpaRepository areaTypeRepository;
	

	@Transactional
	public ReleaseAlias save(ReleaseAlias ReleaseAlias) { 
		return areaTypeRepository.save(ReleaseAlias);
	}
	
	@Transactional
	public List<ReleaseAlias> saveAll(List<ReleaseAlias> list) { 
		return areaTypeRepository.saveAll(list);
	}

	@Override
	@Transactional
	public  Optional<ReleaseAlias> findById(Long k) {
		return areaTypeRepository.findById(k);
	}
	
	@Transactional
	public  Optional<ReleaseAlias> findOne(Example<ReleaseAlias> example) {
		return areaTypeRepository.findOne(example);
	}

}
