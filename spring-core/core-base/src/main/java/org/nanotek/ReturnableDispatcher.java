package org.nanotek;

import org.nanotek.Base;

@FunctionalInterface
public interface ReturnableDispatcher<K extends Base<?>>  {

	public <I> I dispatch (K bean);
	
}
