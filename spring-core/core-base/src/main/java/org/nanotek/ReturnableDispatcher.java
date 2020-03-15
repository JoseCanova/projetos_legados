package org.nanotek;

@FunctionalInterface
public interface ReturnableDispatcher<K extends Base>  {

	 <I> I dispatch (K bean);
	
}
