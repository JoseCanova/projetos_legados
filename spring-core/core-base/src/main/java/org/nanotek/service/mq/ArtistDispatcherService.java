package org.nanotek.service.mq;

import java.util.concurrent.Future;

import org.nanotek.ReturnableDispatcher;
import org.nanotek.apachemq.ArtistNameBeanMessageSender;
import org.nanotek.beans.ArtistName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistNameDispatcherService implements ReturnableDispatcher<ArtistName>{

	@Autowired
	ArtistNameBeanMessageSender sender;

	@SuppressWarnings("unchecked")
	@Override
	public Future<?> dispatch(ArtistName bean) {
		return sender.sendAsync(bean);
	}

}
