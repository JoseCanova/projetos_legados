package org.nanotek;

import java.io.Serializable;

public interface MutableArtistCommentEntity<K extends Serializable> extends ArtistCommentEntity<K>{
		void setArtistComment(K k);
}
