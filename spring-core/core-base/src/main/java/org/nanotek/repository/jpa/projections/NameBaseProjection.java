package org.nanotek.repository.jpa.projections;

import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableNameEntity;

public @Projection interface  NameBaseProjection<E extends MutableNameEntity<String>>{
	Iterable<?> findByNameContainingIgnoreCase(@NotNull String name);
}
