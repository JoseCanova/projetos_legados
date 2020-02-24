package org.nanotek.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.hibernate.service.Service;
import org.springframework.validation.annotation.Validated;

@FunctionalInterface
public interface BaseService<O  , K> extends Service {
	@Validated(value = Default.class)
	Optional<O> findById(@NotNull K k );
}
