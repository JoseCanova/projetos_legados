package org.nanotek.csv;

import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.BooleanBase;
import org.nanotek.IdBase;
import org.nanotek.Result;

public interface PredicateBase<T extends IdBase<?,?> , ID extends IdBase<?,?>> extends Base<T>{
	Optional<ID> evaluate(T immutable);
}
