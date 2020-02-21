package org.nanotek.service.mq;

import org.nanotek.Dispatcher;
import org.nanotek.apachemq.AsyncBaseSender;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ArtistCreditBeanJmsDispatcher implements Dispatcher<ArtistCreditBean>{

	@Autowired
	@Qualifier("ArtistCreditBeanMessageSender")
	AsyncBaseSender<ArtistCreditBean> sender;
	
	public ArtistCreditBeanJmsDispatcher() {
	}

	@Override
	public void dispatch(ArtistCreditBean bean) {
		sender.sendAsync(bean);
	}

}
