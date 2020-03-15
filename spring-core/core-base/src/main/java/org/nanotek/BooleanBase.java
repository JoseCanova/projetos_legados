package org.nanotek;

import java.util.Optional;

public interface BooleanBase<K extends IdBase<?> , ID extends Base<?>> extends  ImmutableBase<K,ID>  {
	Optional<ID> getResult();
}
