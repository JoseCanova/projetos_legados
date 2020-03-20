package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.DatableBase;

public interface DatableBaseRepository<D extends DatableBase<D,?,?,?>> extends SequenceLongBaseRepository<DatableBaseRepository<D>,D>{
}
