package org.nanotek;

import java.io.Serializable;
import java.util.Optional;

import org.apache.commons.collections4.Predicate;

public interface BaseEntity<K extends Base<K> , ID extends Serializable> extends IdentityPredicate<K> , IdBase<K,ID> , Entity<K>{
	
		default  Optional<BaseEntity<K,ID>> compute(Predicate<BaseEntity<K,ID>> predicate) {
			boolean eval = Optional.ofNullable(predicate.evaluate(this)).orElseThrow(BaseException::new);
			return eval ? asOptional() : Optional.empty();
		}
		
		default Optional<BaseEntity<K,ID>> asOptional() {
			return Optional.of(this);
		}
}
