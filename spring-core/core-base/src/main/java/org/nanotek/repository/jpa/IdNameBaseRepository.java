package org.nanotek.repository.jpa;

import java.io.Serializable;

import org.nanotek.IdNameBase;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface IdNameBaseRepository <K extends Serializable , I extends IdNameBase<K, ?>> extends IdBaseRepository<I,K> , NameBaseProjection<I>{
}
