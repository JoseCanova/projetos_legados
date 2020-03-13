package org.nanotek.repository.jpa.projections;

import org.nanotek.BaseDescriptionIdBase;

public interface DescriptionBaseProjection<D , K extends BaseDescriptionIdBase<?,D>>{
	Iterable<K> findByDescriptionContaining(D d);
}
