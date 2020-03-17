package org.nanotek;

public interface PositionableEntityBase<P extends PositionableEntityBase<P,T> , T extends IdBase<T,?>> extends Positionable<P>{
	
	P getPosition();

}
