package org.nanotek.beans.entity;

import java.io.Serializable;

public interface MutableAreaCommentEntity<K extends Serializable> extends AreaCommentEntity<K> {

	void setAreaComment(K k);
	
}
