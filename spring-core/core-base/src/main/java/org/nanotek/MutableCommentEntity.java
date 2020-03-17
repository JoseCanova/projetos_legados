package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public interface MutableCommentEntity<K extends Base<?>,ID extends Serializable> extends CommentEntity<K> , Base<K> , Id<ID>{

	void setComment(@NotNull K k);
	
}
