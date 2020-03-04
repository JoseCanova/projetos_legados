package org.nanotek.service.jpa;

import org.nanotek.beans.entity.Language;
import org.nanotek.repository.jpa.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanguageJpaService {

	@Autowired
	LanguageRepository repository;
	
	public LanguageJpaService() {
	}

	@Transactional
	public Language save(Language bean) { 
		return repository.save(bean);
	}
	
}
