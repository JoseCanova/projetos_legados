package org.nanotek.service.mediator;

import java.util.List;

import org.nanotek.EntityBaseTransformer;
import org.nanotek.Mediator;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.exception.validator.ViolationException;
import org.nanotek.service.ArtistCreditService;
import org.nanotek.service.tranformer.ArtistCreditBeanTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value="ArtistCreditMediator")
public class ArtistCreditMediator extends ArtistCreditService implements EntityBaseTransformer<ArtistCreditBean,ArtistCredit> , Mediator<ArtistCreditBean> {
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
		
	@Autowired 
	@Qualifier("ArtistCreditBeanTransformer")
	ArtistCreditBeanTransformer transformer;
	
	@Override
	public void mediate(ArtistCreditBean bean) {
		try { 
			transformAndSave(bean);
		}catch (Exception ex) {
			logger.error("erro prcessando mediacao" , ex);
			logger.info(bean.toJson());
		}
	}

	private void transformAndSave(ArtistCreditBean bean) throws ViolationException {
		ArtistCredit ac = transform(bean);
		save(ac);
	}

	@Override
	public ArtistCredit transform(ArtistCreditBean i) {
		return transformer.transform(i);
	}

	@Override
	public List<ArtistCredit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtistCredit> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArtistCredit> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ArtistCredit> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ArtistCredit> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<ArtistCredit> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArtistCredit getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ArtistCredit> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ArtistCredit> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
}
