package org.nanotek.service.jpa;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.RecordingAlias;
import org.nanotek.repository.jpa.RecordingAliasJpaRepository;
import org.nanotek.service.LongIdSortNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordingAliasJpaService<K extends RecordingAlias<K>> extends BasePersistenceService<K,RecordingAliasJpaRepository> {

	public RecordingAliasJpaService(@Autowired RecordingAliasJpaRepository rep) {
		super(rep);
	}

	@Override
	public Iterable<RecordingAlias> findByNameContainingIgnoreCase(@NotNull String name) {
		// TODO Auto-generated method stub
		return baseRepository.ffindByNameContainingIgnoreCase(name);
	}

}
