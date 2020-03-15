package org.nanotek;

import java.util.Optional;
import java.util.function.Predicate;

public interface BooleanBase<ID extends IdBase<?>> extends  ImmutableBase<ID>  {
	
	Optional<Boolean> getResult();
	
	@Override
	default <B extends Base<?>> Optional<Result<?>> on(Predicate<ID> k) {
		return Optional.of(new Result<>(this.getId(), k.test(getId())));
	}
	

}
