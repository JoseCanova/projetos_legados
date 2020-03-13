package org.nanotek;

import java.io.Serializable;

public interface BaseDescriptionBase<ID extends Serializable, K> extends EntityBase<ID>{
	
	K getDescription();
	void setDescription(K id);

}
