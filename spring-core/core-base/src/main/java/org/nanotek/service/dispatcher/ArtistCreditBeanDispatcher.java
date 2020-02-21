package org.nanotek.service.dispatcher;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.service.ArtistCreditService;
import org.nanotek.service.tranformer.ArtistCreditBeanTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistCreditBeanDispatcher implements EntityDispatcher<ArtistCreditBean , ArtistCredit>{

	@Autowired
	ArtistCreditService service;
	
	@Autowired 
	ArtistCreditBeanTransformer transformer;

	@Override
	public void dispatch(ArtistCredit bean) {
		service.save(bean);
	}

	@Override
	public ArtistCredit transform(ArtistCreditBean i) {
		return transformer.transform(i);
	}

}
