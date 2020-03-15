package org.nanotek;

import java.io.Serializable;

public interface IdBase<K extends IdBase<K,ID>,ID extends Serializable> extends Base<IdBase<K,ID>> , Id<ID> {
	default IdBase<K,ID> getIdBase(){
		return this;
	}
	
	
}
