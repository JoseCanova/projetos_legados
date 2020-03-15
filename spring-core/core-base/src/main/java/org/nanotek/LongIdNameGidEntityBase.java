package org.nanotek;

import java.io.Serializable;

public interface LongIdNameGidEntityBase<K extends Serializable, N extends Serializable> extends LongIdNameEntityBase<N>  {
	K getGid();
	
}
