package org.nanotek.service.mediator;

import javax.validation.Valid;

import org.nanotek.EntityBaseTransformer;
import org.nanotek.Mediator;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.service.ArtistCreditService;
import org.nanotek.service.tranformer.ArtistCreditBeanTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jdk.internal.jline.internal.Log;

@Service
@Validated
public class ArtistCreditMediator extends ArtistCreditService implements EntityBaseTransformer<ArtistCreditBean,ArtistCredit> , Mediator<ArtistCreditBean> {
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
		
	@Autowired 
	ArtistCreditBeanTransformer transformer;

	@Override
	public void mediate(ArtistCreditBean bean) {
		try { 
			transformAndSave(bean);
		}catch (Exception ex) {
			logger.error("erro prcessando mediacao" , ex);
			Log.info(bean.toJson());
		}
	}

	private void transformAndSave(@Valid ArtistCreditBean bean) {
		ArtistCredit ac = transformer.transform(bean);
		save(ac);
	}

	@Override
	public ArtistCredit transform(ArtistCreditBean i) {
		return transformer.transform(i);
	}
}
