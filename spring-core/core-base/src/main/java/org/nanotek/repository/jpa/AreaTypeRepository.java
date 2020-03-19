package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.AreaType;
import org.nanotek.repository.jpa.projections.BaseTypeProjection;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaTypeRepository<K extends AreaType<K>> extends  
BaseTypeProjection<K> ,  
IdBaseRepository<K> , 
NameBaseProjection<K,String>{ 
}
