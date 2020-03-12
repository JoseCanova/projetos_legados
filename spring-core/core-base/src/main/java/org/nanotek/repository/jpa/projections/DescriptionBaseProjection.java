package org.nanotek.repository.jpa.projections;

import org.nanotek.BaseDescriptionBase;

public interface DescriptionBaseProjection<D , K extends BaseDescriptionBase<D>>{
	Iterable<K> findByDescriptionContaining(D d);
}
