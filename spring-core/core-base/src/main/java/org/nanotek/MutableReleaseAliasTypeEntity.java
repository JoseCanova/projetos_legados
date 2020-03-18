package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseAliasTypeEntity<K extends Serializable> extends ReleaseAliasTypeEntity<K>{
		void setReleaseAliasType(K k);
}
