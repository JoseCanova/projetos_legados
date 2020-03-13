package org.nanotek.service.jpa;

import org.nanotek.beans.entity.InstrumentType;
import org.nanotek.configuration.csv.AreaIntegrationConfiguration;
import org.nanotek.repository.jpa.InstrumentTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class InstrumentTypeJpaService extends BaseTypePersistenceService<InstrumentType, InstrumentTypeRepository> {

	private final Logger logger = LoggerFactory.getLogger(AreaIntegrationConfiguration.class);
	
	public InstrumentTypeJpaService(@Autowired InstrumentTypeRepository rep) {
		super(rep);
	}

	
}
