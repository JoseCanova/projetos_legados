package org.nanotek;

import java.io.Serializable;

public interface IdBase<K extends Serializable> extends Base<IdBase<K>> , Id<K> {

	K getId();

}
