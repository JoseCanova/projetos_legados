package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.ReleaseAliasSortNameEntity;

public interface MutableReleaseAliasSortNameEntity<K extends Serializable> extends ReleaseAliasSortNameEntity<K>{
  void setReleaseAliasSortName(K k);
}
