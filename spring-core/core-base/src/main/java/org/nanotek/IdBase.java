package org.nanotek;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Predicate;

import org.nanotek.beans.entity.Artist;

public interface IdBase<K extends Serializable> extends Base<IdBase<K>> , Id<K> , ImmutableBase<IdBase<K>>{

	K getId();

}
