package org.nanotek.service.jpa;

import java.io.Serializable;

import org.nanotek.BaseDescriptionBase;
import org.nanotek.BaseDescriptionIdBase;
import org.nanotek.IdBase;
import org.nanotek.repository.jpa.BaseDescriptionBaseRepository;
import org.nanotek.repository.jpa.IdBaseRepository;

public interface BaseDescriptionBaseIdRepository
		<O extends BaseDescriptionIdBase<ID , D>, K extends BaseDescriptionBase<D> , ID extends Serializable , RID extends IdBase<ID> , D extends Serializable>  
		extends BaseDescriptionBaseRepository<K , ID> , IdBaseRepository<RID, ID>{
}
