package org.nanotek;

import java.io.Serializable;

public interface Mutables<K extends IdBase<K,ID>,ID extends Serializable>  extends IdBase<K,ID> , MutableBase<K>{
}
