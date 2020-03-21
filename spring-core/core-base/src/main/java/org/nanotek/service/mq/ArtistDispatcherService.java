package org.nanotek.service.mq;

import java.util.concurrent.Future;

import org.nanotek.ReturnableDispatcher;
import org.nanotek.apachemq.ArtistBeanMessageSender;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistDispatcherService<K extends ArtistBean<K,?> , ID extends Future<ID>> implements ReturnableDispatcher<K,ID>{

	@Autowired
	ArtistBeanMessageSender sender;

	@Override
	public ID dispatch(K bean) {
		return sender.sendAsync(bean);
	}
//	@SuppressWarnings("unchecked")
//	@Override
//	public Future<?> dispatch(ArtistBean bean) {
//		return sender.sendAsync(bean);
//	}

}
