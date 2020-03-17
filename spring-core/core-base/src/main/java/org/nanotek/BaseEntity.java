package org.nanotek;

import java.util.Optional;

import org.apache.commons.collections4.Predicate;

public interface BaseEntity extends IdentityPredicate<BaseEntity>{
		default  Optional<BaseEntity> evaluate(Predicate<BaseEntity> object) {
			return Optional.empty();
		}
}
