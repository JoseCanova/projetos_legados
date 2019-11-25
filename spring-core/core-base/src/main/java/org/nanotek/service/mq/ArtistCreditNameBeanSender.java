package org.nanotek.service.mq;

import org.nanotek.DispatcherService;
import org.nanotek.apachemq.BaseBeanSender;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.springframework.beans.factory.annotation.Autowired;

public class ArtistCreditNameBeanSender implements DispatcherService<ArtistCreditNameBean> {

	@Autowired
	BaseBeanSender<ArtistCreditNameBean> sender;
	
	@Override
	public void dispatch(ArtistCreditNameBean bean) {
		sender.send(bean);
	}

}
