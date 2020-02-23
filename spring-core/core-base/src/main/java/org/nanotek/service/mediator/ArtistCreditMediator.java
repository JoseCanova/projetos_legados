package org.nanotek.service.mediator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.validation.groups.Default;

import org.nanotek.EntityBaseTransformer;
import org.nanotek.Mediator;
import org.nanotek.beans.ArtistCredit;
import org.nanotek.beans.csv.ArtistCreditBean;
import org.nanotek.exception.validator.ViolationException;
import org.nanotek.service.ArtistCreditService;
import org.nanotek.service.tranformer.ArtistCreditBeanTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@EnableCaching
@Qualifier(value="ArtistCreditMediator")
@ValidateOnExecution(type = ExecutableType.ALL)
public class ArtistCreditMediator extends ArtistCreditService implements EntityBaseTransformer<ArtistCreditBean,ArtistCredit> , Mediator<ArtistCreditBean> {
		
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
		
	@Autowired 
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

	@Validated(value = Default.class)
	private void transformAndSave(@Valid ArtistCreditBean bean) throws ViolationException {
		ArtistCredit ac = transform(bean);
		//save(ac);
	}

	@Override
	public ArtistCredit transform(ArtistCreditBean i) {
		return transformer.transform(i);
	}
}
