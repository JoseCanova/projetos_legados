package org.nanotek.apachemq.listener;

import java.util.List;
import java.util.Optional;

import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.apache.activemq.command.Message;
import org.apache.activemq.util.ByteSequence;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.ArtistName;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.nanotek.service.ArtistService;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.nanotek.service.jpa.ArtistCreditNameJpaService;
import org.nanotek.service.jpa.ArtistNameJpaService;
import org.nanotek.service.tranformer.ArtistCreditNameTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

@Service
public class ArtistCreditNameBeanJmsListener implements SessionAwareMessageListener<ActiveMQBytesMessage>{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private Gson gson;

	@Autowired 
	private ArtistCreditNameTransformer transformer;

	@Autowired 
	private ArtistCreditNameJpaService jpaService;

	@Autowired
	private ArtistService artistJpaService;
	
	@Autowired 
	private ArtistNameJpaService artistNameJpaService;
	
	@Autowired
	private ArtistCreditJpaService artistCreditJpaService;

	/*
	 * @Autowired private ArtistCreditNameBeanValidator validator;
	 */

	@Override
	@Async
	public void onMessage(ActiveMQBytesMessage message, Session session) throws JMSException {
		Message innerMessage = message.getMessage();
		ByteSequence sequence = innerMessage.getContent();
		String payload = new String (sequence.data);
		ArtistCreditNameBean artistCreditName = gson.fromJson(payload , ArtistCreditNameBean.class);
		log.info(payload);
		ArtistCreditName acn  = null;
		try { 
			acn = transformer.transform(artistCreditName);
		}catch (Exception ex) { 
			ex.printStackTrace();
			log.info(ex.getMessage());
		}
		if(acn != null) { 
			try { 
				jpaService.save(acn);
				saveArtistNameCreditRel(artistCreditName);
			}catch (Exception ex) { 
				ex.printStackTrace();
				log.info(ex.getMessage());
			}
		}
	}

	@Transactional
	private void saveArtistNameCreditRel(ArtistCreditNameBean artistCreditName) {
		if (artistCreditName.getArtistId() !=null) {
			List<ArtistName> list = artistJpaService.findByArtistId(artistCreditName.getArtistId());
			if(list.size()> 0) {
				log.info("FOUND_ARTIST_NAME");
				ArtistName artistName  = list.stream().findFirst().get();
				if (artistCreditName.getArtistCreditId() !=null) { 
					Optional<ArtistCredit> opt = artistCreditJpaService.findByArtistCreditId(artistCreditName.getArtistCreditId());
					if(opt !=null && opt.isPresent()) { 
						artistName.getArtistCredits().add(opt.get());
						ArtistCredit ac = opt.get();
						ac.getArtists().add(artistName);
						log.info("ADDING ARTIST_CREDIT_NAME_REL");
						artistCreditJpaService.save(opt.get());
						artistNameJpaService.save(artistName);
					}
				}
			}
		}
	}

}
