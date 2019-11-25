package org.nanotek.apachemq.listener;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQBytesMessage;
import org.apache.activemq.command.Message;
import org.apache.activemq.util.ByteSequence;
import org.nanotek.beans.ArtistCreditName;
import org.nanotek.beans.ArtistName;
import org.nanotek.beans.csv.ArtistCreditNameBean;
import org.nanotek.service.ArtistService;
import org.nanotek.service.jpa.ArtistCreditNameJpaService;
import org.nanotek.service.jpa.ArtistNameJpaService;
import org.nanotek.service.tranformer.ArtistCreditNameTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
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

	/*
	 * @Autowired private ArtistCreditNameBeanValidator validator;
	 */

	@Override
	public void onMessage(ActiveMQBytesMessage message, Session session) throws JMSException {
		log.info("Received JMSTYPE: "+ message.getJMSType());		
		log.info("Received JMSTYPE: "+ message.getJMSXMimeType());
		Message innerMessage = message.getMessage();
		ByteSequence sequence = innerMessage.getContent();
		String payload = new String (sequence.data);
		ArtistCreditNameBean artistCreditName = gson.fromJson(payload , ArtistCreditNameBean.class);
		log.info(payload);
		ArtistCreditName acn  = null;
		try { 
			acn = transformer.transform(artistCreditName);
		}catch (Exception ex) { 
			log.info(ex.getMessage());
		}
		if(acn != null) { 
			try { 
				jpaService.save(acn);
				saveArtistNameCreditRel(acn);
			}catch (Exception ex) { 
				log.info(ex.getMessage());
			}
		}
	}

	@Transactional
	private void saveArtistNameCreditRel(ArtistCreditName acn) {
		if (acn.getArtistName() !=null) {
			List<ArtistName> list = artistJpaService.findByArtistId(acn.getArtistName().getArtistId());
			if(list.size()> 0) { 
				ArtistName artistName  = list.stream().findFirst().get();
				if (acn.getArtistCredit() !=null 
							&& !artistName.getArtistCredits().contains(acn.getArtistCredit())) { 
					artistName.getArtistCredits().add(acn.getArtistCredit());
					artistNameJpaService.save(artistName);
				}
			}
		}
	}

}
