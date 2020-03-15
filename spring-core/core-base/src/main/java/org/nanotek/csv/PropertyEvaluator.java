package org.nanotek.csv;

import java.util.Optional;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections4.Predicate;
import org.nanotek.Holder;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component 
@DependsOn(value = "ApachePropertyUtils")
@Qualifier(value = "ApachePropertyEvaluator")
public class PropertyEvaluator<K extends IdBase<K , ID> , ID extends IdBase<K, ID>> implements  IdBase<K,ID> , Holder<K,ID>{

	private static final long serialVersionUID = 2903074877298759664L;
	
	PropertyUtils propertyUtils;

	@Override
	public ID getId() {
		return null;
	}

	@Override
	public Optional<Result<?>> on(Predicate<K> k) {
		return null;
	}
	
}
