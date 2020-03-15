package org.nanotek;

import java.util.Optional;

public interface BooleanBase<ID extends IdBase<?>> extends  ImmutableBase<BooleanBase<ID>> , Holder<ID> {
	Optional<Boolean> result;
}
