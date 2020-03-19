package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.InstrumentType;
import org.nanotek.repository.jpa.projections.BaseTypeProjection;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentTypeRepository<K extends InstrumentType<K>>  extends 
IdBaseRepository<K>,
BaseTypeProjection<K>,
NameBaseProjection<K,String>{
}