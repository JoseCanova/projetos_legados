package org.nanotek;

import java.io.Serializable;

public interface BooleanBase<K extends IdBase<?>,ID extends Serializable> extends  ImmutableBase<BooleanBase<?,ID>> , Holder<K> {
}
