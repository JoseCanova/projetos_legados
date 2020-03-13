package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Medium;
import org.nanotek.repository.jpa.MediumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediumJpaService extends LongIdNameEntityService<Medium,MediumRepository> {

	public MediumJpaService(@Autowired MediumRepository rep) {
		super(rep);
	}

}
