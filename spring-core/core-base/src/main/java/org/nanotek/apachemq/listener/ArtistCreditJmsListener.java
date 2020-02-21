package org.nanotek.apachemq.listener;

import org.nanotek.Mediator;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.service.mediator.ArtistCreditMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value="ArtistCreditListener")
public class ArtistCreditJmsListener extends BaseBeanJmsListener<ArtistCreditBean,ArtistCredit>{

	@Autowired 
	ArtistCreditMediator dispatcher;
	
	public ArtistCreditJmsListener() {
	}

	@Override
	protected Mediator<ArtistCreditBean> getMediator() {
		return dispatcher;
	}

	@Override
	protected Class<ArtistCreditBean> getClazz() {
		return ArtistCreditBean.class;
	}

}
