package org.nanotek;

import java.io.Serializable;

public interface ImmutableLengthIdBase<K extends Serializable, ID extends Serializable> extends IdBase<ID>{

	K getLength();
}
