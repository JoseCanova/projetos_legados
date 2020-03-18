package org.nanotek;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;

public interface BaseEntity<K extends BaseEntity<?>> extends IdentityPredicate<BaseEntity<?>> {
		default  Optional<BaseEntity<?>> compute(Predicate<BaseEntity<?>> predicate) {
			boolean eval = Optional.ofNullable(predicate.evaluate(this)).orElseThrow(BaseException::new);
			return eval ? asOptional() : Optional.empty();
		}
		
		default Optional<BaseEntity<?>> asOptional() {
			return Optional.of(this);
		}
}
