package org.nanotek;

import java.io.Serializable;

import org.nanotek.entities.MutableIdBase;

public interface StringBase<K extends IdBase<K,ID>,ID extends Serializable> extends ImmutableBase<K,ID> {
}
