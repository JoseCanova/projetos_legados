package org.nanotek;

import org.nanotek.Base;

@FunctionalInterface
public interface Dispatcher<K extends Base>  {

	public  void dispatch (K bean);
	
}
