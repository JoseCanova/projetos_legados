package org.nanotek.service.mq;

import org.nanotek.Dispatcher;
import org.nanotek.apachemq.BaseBeanSender;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistCreditNameBeanDispacherService implements Dispatcher<ArtistCreditNameBean> {

	@Autowired
	BaseBeanSender<ArtistCreditNameBean> sender;
	
	@Override
	public void dispatch(ArtistCreditNameBean bean) {
		sender.sendAsync(bean);
	}

}
