package org.nanotek.repository.jpa.projections;

import javax.validation.constraints.NotNull;

import org.nanotek.NameBase;


public @Projection interface  NameBaseProjection<K extends NameBase> {
	Iterable<K> findByNameContainingIgnoreCase(@NotNull String name);
}
