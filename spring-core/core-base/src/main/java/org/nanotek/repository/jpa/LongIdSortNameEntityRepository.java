package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.LongIdSortName;

public interface LongIdSortNameEntityRepository<K extends LongIdSortName<K>> 
extends SequenceLongBaseRepository<LongIdSortNameEntityRepository<K>,K> {
}
