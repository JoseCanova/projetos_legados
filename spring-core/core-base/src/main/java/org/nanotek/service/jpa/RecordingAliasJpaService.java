package org.nanotek.service.jpa;

import org.nanotek.beans.entity.RecordingAlias;
import org.nanotek.repository.jpa.RecordingAliasJpaRepository;
import org.nanotek.service.LongIdSortNameEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordingAliasJpaService extends LongIdSortNameEntityService<RecordingAlias,RecordingAliasJpaRepository> {

	public RecordingAliasJpaService(@Autowired RecordingAliasJpaRepository rep) {
		super(rep);
	}

}
