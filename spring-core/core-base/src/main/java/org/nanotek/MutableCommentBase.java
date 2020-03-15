package org.nanotek;

import java.io.Serializable;

public interface MutableCommentBase<K extends IdBase<?,?>,S extends Serializable> {

	void setComment(S k);
	
}
