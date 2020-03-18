package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseAliasEndDateEntity<K extends Serializable> extends ReleaseAliasEndDateEntity<K>{

	void setReleaseAliasEndDate(K k);
}
