package org.nanotek.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.IdBase;

public interface PredicateBase<T extends IdBase<T,ID> , ID extends IdBase<?,?>> extends Base<ID>{
	Optional<ID> evaluate(T immutable);
}
