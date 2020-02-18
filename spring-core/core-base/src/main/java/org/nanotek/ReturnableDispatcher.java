package org.nanotek;

import org.nanotek.Base;

@FunctionalInterface
public interface ReturnableDispatcher<K extends Base>  {

	 <I> I dispatch (K bean);
	
}
