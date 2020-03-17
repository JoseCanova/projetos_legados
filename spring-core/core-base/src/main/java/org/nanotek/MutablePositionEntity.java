package org.nanotek;

import java.io.Serializable;

public interface MutablePositionEntity<K extends Serializable> extends PositionEntity<K>{
	void setPosition(K k);
}
