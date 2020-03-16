package org.nanotek;

import java.util.Optional;

public interface BooleanBase<K extends IdBase<K,ID> , ID extends BooleanBase<K, ID>> extends  ImmutableBase<ID,ID> , Holder<K, ID>{
	Optional<ID> getResult();
}
