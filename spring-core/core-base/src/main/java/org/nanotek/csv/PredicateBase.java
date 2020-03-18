package org.nanotek.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.IdBase;

public interface PredicateBase<T extends IdBase<?,?> , ID extends IdBase<?,?>> extends Base<T>{
	Optional<ID> evaluate(T immutable);
}
