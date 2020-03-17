package org.nanotek;  

import java.io.Serializable;

public interface PositionEntity<K extends Serializable> extends BaseEntity, Positionable<K> {
	K getPosition();
}
