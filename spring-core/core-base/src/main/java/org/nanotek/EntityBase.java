package org.nanotek;

import java.io.Serializable;

public interface EntityBase<K extends IdBase<K,ID>,ID extends Serializable> extends Mutables<K,ID>{
}
