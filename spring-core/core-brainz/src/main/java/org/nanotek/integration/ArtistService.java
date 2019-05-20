package org.nanotek.integration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.nanotek.Base;
import org.nanotek.beans.ArtistName;
import org.nanotek.repository.ArtistNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value="artistService")
public class ArtistService implements ApplicationContextAware{

	private Logger log = Logger.getLogger(ArtistService.class);
	
	@Autowired
	ArtistNameRepository artistNameRepository; 
	
	ApplicationContext applicationContext;
	
	static AtomicInteger  atomicInteger = new AtomicInteger(0);
	
	Integer maxRecords = 2000; 
	
	public ArtistService() {
	}
	
	@ServiceActivator/*(inputChannel="baseInputRecordChannel" , outputChannel="bootChannel" )*/
	public <T> Message<?> buildBaseMessage(T payload) 
	{
		
		Message <?> message = MessageBuilder.withPayload(payload).build();
		
		return message;
		
	}
	
	@Transactional
	@Splitter/*(inputChannel="bootChannel" , outputChannel="artistNameInputChannel")*/
	public <T extends Base<?>> List<?> processResultPage(Page<T> page)
	{ 
			
			if (page.isLastPage())
				atomicInteger.set(0);
			else
				atomicInteger.set(atomicInteger.get() + 1);
			
			System.out.println("Size of atom " + atomicInteger.get());
			 List<T> resultList = Collections.unmodifiableList(page.getContent());
			 log.debug("process result page " + page);
		 return resultList;
	}

	public Page<?>  processArtistRequest()
	{ 
		
		List<String> values = new ArrayList<String>();
		values.add("name");
		
		PageRequest pageRequest =  new PageRequest(atomicInteger.get() ,  maxRecords , new Sort(Sort.Direction.ASC , Collections.unmodifiableList(values)));
		
		return artistNameRepository.findAll(pageRequest);
		 
	}
	
	public ArtistName findById(Long id) {
		return artistNameRepository.findById(id);
	}
	
	
	public List<ArtistName> findByNameLike(String name)
	{ 
		return artistNameRepository.findByNameLike(name);
	}

	public List<ArtistName> findByNameIgnoreCase(String name) {
		return artistNameRepository.findByNameIgnoreCase(name);
	}

	public List<ArtistName> findByNameLikeIgnoreCase(String name) {
		return artistNameRepository.findByNameLikeIgnoreCase(name);
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
