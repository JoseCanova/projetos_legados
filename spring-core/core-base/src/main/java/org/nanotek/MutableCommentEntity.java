package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public interface MutableCommentEntity<K extends Serializable> extends CommentEntity<K>{

	void setComment(@NotNull K k);
	
}
