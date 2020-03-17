package org.nanotek;

import java.io.Serializable;

public interface MutableInstrumentEntity<K extends Serializable> extends InstrumentEntity<K> {
     void setInstrument(K k);
}
