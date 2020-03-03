package org.nanotek;

import java.io.Serializable;

public interface BooleanBase<K extends Serializable> extends Base, MutableBase<K>, ImmutableBase<K> {
}
