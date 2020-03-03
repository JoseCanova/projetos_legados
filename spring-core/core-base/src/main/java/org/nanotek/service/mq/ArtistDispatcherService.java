package org.nanotek.service.mq;

import java.util.concurrent.Future;

import org.nanotek.ReturnableDispatcher;
import org.nanotek.apachemq.ArtistBeanMessageSender;
import org.nanotek.beans.csv.ArtistBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistDispatcherService implements ReturnableDispatcher<ArtistBean>{

	@Autowired
	ArtistBeanMessageSender sender;

	@SuppressWarnings("unchecked")
	@Override
	public Future<?> dispatch(ArtistBean bean) {
		return sender.sendAsync(bean);
	}

}
