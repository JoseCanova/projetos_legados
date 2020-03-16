package org.nanotek;

public interface Positionable<P extends Positionable<P,T> , T extends IdBase<T,?>>{
	P getPosition();
}
