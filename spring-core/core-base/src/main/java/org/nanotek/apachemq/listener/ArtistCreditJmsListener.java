package org.nanotek.apachemq.listener;

import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.service.dispatcher.ArtistCreditBeanDispatcher;
import org.nanotek.service.dispatcher.EntityDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value="ArtistCreditListener")
public class ArtistCreditJmsListener extends BaseBeanJmsListener<ArtistCreditBean,ArtistCredit>{

	@Autowired 
	ArtistCreditBeanDispatcher dispatcher;
	
	public ArtistCreditJmsListener() {
	}

	@Override
	protected EntityDispatcher<ArtistCreditBean,ArtistCredit> getDispatcher() {
		return dispatcher;
	}

	@Override
	protected Class<ArtistCreditBean> getClazz() {
		return ArtistCreditBean.class;
	}

}
