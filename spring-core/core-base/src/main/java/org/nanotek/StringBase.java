package org.nanotek;

import org.nanotek.entities.MutableIdBase;

public interface StringBase<K extends IdBase<K,String>> extends ImmutableBase<K,String> , MutableIdBase<String> {
}
