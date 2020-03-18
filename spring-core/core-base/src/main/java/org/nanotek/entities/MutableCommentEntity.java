package org.nanotek.entities;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.nanotek.CommentEntity;

public interface MutableCommentEntity<K extends Serializable> extends CommentEntity<K>{

	void setComment(@NotNull K k);
	
}
