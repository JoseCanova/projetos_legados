package org.nanotek;

import java.io.Serializable;

public interface MutableReleaseAliasSortNameEntity<K extends Serializable> extends ReleaseAliasSortNameEntity<K>{
  void setReleaseAliasSortName(K k);
}
