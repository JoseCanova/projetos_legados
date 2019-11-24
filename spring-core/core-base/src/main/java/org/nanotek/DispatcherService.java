package org.nanotek;

import org.nanotek.Base;

@FunctionalInterface
public interface DispatcherService<K extends Base<?>>  {

	public  void dispatch (K bean);
	
}
