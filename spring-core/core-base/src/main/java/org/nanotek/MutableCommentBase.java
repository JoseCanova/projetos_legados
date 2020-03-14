package org.nanotek;

import java.io.Serializable;

public interface MutableCommentBase<K extends Serializable> extends Mutable<K> , Holder<K>{

	void setComment(K k);
	
}
