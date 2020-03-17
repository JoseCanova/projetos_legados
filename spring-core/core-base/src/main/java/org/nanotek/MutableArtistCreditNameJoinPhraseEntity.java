package org.nanotek;

import java.io.Serializable;

public interface MutableArtistCreditNameJoinPhraseEntity<K extends Serializable> extends ArtistCreditNameJoinPhraseEntity<K> {
	
	void setArtistCreditJoinPhrase(K k);
  
}
