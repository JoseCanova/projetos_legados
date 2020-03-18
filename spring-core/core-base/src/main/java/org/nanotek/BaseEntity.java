package org.nanotek;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;

public interface BaseEntity extends IdentityPredicate<BaseEntity>{
		default  Optional<BaseEntity> evaluate(Predicate<BaseEntity> object) {
			boolean eval = Optional.ofNullable(object.evaluate(this)).orElseThrow(BaseException::new);
			return eval ? Optional.of(this) : BaseEntity.empty();
		}
		
		static Optional<BaseEntity> empty() {
			return Optional.empty();
		}

		default Optional<BaseEntity> get() {
			return Optional.of(this);
		}
}
