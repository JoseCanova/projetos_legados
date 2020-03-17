package org.nanotek;

import java.io.Serializable;

public interface AliasIdEntity<K extends Serializable> {

	K getAliasId();
	
}
