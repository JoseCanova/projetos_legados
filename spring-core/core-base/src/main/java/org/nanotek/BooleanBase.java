package org.nanotek;

import java.util.Optional;

public interface BooleanBase<K extends IdBase<K,K>> extends  ImmutableBase<K,K>  {
	Optional<K> getResult();
}
