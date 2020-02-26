package org.nanotek.repository.jpa.projections;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.nanotek.NameBase;

@Projection
public interface NameableProjection<K extends NameBase> {
	List<K> findByNameContainingIgnoreCase(@NotNull String name);
}
