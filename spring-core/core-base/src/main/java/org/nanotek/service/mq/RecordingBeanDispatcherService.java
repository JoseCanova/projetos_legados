package org.nanotek.service.mq;

import org.nanotek.DispatcherService;
import org.nanotek.apachemq.RecordingBeanMessageSender;
import org.nanotek.beans.csv.RecordingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class RecordingBeanDispatcherService implements DispatcherService<RecordingBean>{ 

	@Autowired
	private RecordingBeanMessageSender sender;

	@Override
	public void dispatch(RecordingBean bean) {
			sender.sendAsync(bean);
	}
	
}
