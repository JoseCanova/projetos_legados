package org.nanotek.service.mq;

import org.nanotek.DispatcherService;
import org.nanotek.apachemq.TrackBeanMessageSender;
import org.nanotek.beans.csv.TrackBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackBeanDispatcherService implements DispatcherService<TrackBean> {

	@Autowired
	private TrackBeanMessageSender sender;
	
	public TrackBeanDispatcherService() { 
		super();
	}
	
	@Override
	public void dispatch(TrackBean bean) {
		sender.sendAsync(bean);
	}

}
