package org.nanotek.service.mq;

import org.nanotek.DispatcherService;
import org.nanotek.apachemq.ReleaseBeanMessageSender;
import org.nanotek.beans.csv.ReleaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseBeanDispatcherService implements DispatcherService<ReleaseBean>{

	@Autowired
	private ReleaseBeanMessageSender sender;
	
	public ReleaseBeanDispatcherService() { 
		super();
	}

	@Override
	public void dispatch(ReleaseBean bean) {
		sender.send(bean);
	}
	
}
