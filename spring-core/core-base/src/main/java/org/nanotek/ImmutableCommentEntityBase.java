package org.nanotek;

import java.io.Serializable;

public interface ImmutableCommentEntityBase<K extends Serializable, ID extends Serializable> extends IdBase<ID>{

	
	K getComment();
	
	
}
