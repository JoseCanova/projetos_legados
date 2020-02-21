package org.nanotek.service.mediator;

import org.nanotek.Mediator;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.service.ArtistCreditService;
import org.nanotek.service.tranformer.ArtistCreditBeanTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistCreditMediator implements Mediator<ArtistCreditBean>{
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
		
	@Autowired
	ArtistCreditService service;
	
	@Autowired 
	ArtistCreditBeanTransformer transformer;

	@Override
	public void mediate(ArtistCreditBean bean) {
		try { 
			ArtistCredit ac = transformer.transform(bean);
			service.save(ac);
		}catch (Exception ex) {
			logger.error("erro prcessando transformacao banco dados" , ex);
		}
	}
}
