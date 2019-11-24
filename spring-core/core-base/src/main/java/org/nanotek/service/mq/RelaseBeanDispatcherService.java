package org.nanotek.service.mq;

import org.nanotek.DispatcherService;
import org.nanotek.apachemq.ReleaseBeanMessageSender;
import org.nanotek.beans.csv.ReleaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelaseBeanDispatcherService implements DispatcherService<ReleaseBean>{

	@Autowired
	private ReleaseBeanMessageSender sender;
	
	public RelaseBeanDispatcherService() { 
		super();
	}

	@Override
	public void dispatch(ReleaseBean bean) {
		sender.send(bean);
	}
	
}
