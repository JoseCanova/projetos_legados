package org.nanotek.csv;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;
import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedBaseClass;
import org.nanotek.opencsv.BaseMap;
import org.nanotek.opencsv.MapColumnStrategy;


public class MapStrategy<J extends WrappedBaseClass<J,ID>,ID extends IdBase<ID,?>>  
implements BaseMapStrategy<J,ID>{
	
	MapColumnStrategy<BaseMap<J,ID>> mapColumnStrategy;

	private static final long serialVersionUID = 1L;

	public MapStrategy() {
	}

	@Override
	public Optional<Result<J, ?>> findProperty(Predicate<Class<ID>> evaluator) {
		return null;
	}

}
