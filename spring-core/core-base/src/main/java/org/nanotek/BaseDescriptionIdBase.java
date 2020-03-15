package org.nanotek;

import java.io.Serializable;

public interface BaseDescriptionIdBase<K extends IdBase<K,ID>, I extends Serializable, ID extends Serializable> extends BaseDescriptionBase<K,K,ID>  {
	
	I getDescriptionId();
	
	void setDescriptionId(I id);

}
