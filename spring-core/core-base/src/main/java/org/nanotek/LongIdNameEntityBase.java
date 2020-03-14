package org.nanotek;

import java.io.Serializable;

public interface LongIdNameEntityBase<K extends Serializable> extends LongIdEntityBase{

	
	K getName();
	
}
