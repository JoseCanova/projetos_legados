package org.nanotek;

public interface MutableCommentBase<K extends IdBase<?>> {

	void setComment(K k);
	
}
