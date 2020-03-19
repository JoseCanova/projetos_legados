package org.nanotek.repository.jpa.projections;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.nanotek.entities.MutableNameEntity;

public @Projection interface  NameBaseProjection<E extends MutableNameEntity<N> , N extends Serializable>{
	Iterable<E> findByNameContainingIgnoreCase(@Valid @NotNull N name);
}
