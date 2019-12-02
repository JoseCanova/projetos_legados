package org.nanotek.service.mq;

import java.util.concurrent.Future;

import org.nanotek.ReturnableDispatcher;
import org.nanotek.apachemq.RecordingBeanMessageSender;
import org.nanotek.beans.csv.RecordingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class RecordingBeanDispatcherService implements ReturnableDispatcher<RecordingBean>{ 

	@Autowired
	private RecordingBeanMessageSender sender;

	@SuppressWarnings("unchecked")
	@Override
	public  Future<?> dispatch(RecordingBean bean) {
			return sender.sendAsync(bean);
	}
	
}
