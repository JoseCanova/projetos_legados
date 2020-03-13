package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Area;
import org.nanotek.repository.jpa.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaJpaService extends LongIdNameEntityService<Area , AreaRepository>  {
	
	public AreaJpaService (@Autowired AreaRepository rep){ 
		super(rep);
	}
	
}
