package org.nanotek.repository.jpa;


import org.nanotek.beans.entity.LongIdGidName;
import org.nanotek.repository.jpa.projections.GidBaseProjection;
import org.nanotek.repository.jpa.projections.NameBaseProjection;

public interface LongIdGidNameEntityRepository<K extends LongIdGidName<K,String,String>> 
extends IdBaseRepository<K>,
NameBaseProjection<K,String>,
GidBaseProjection<K,String>{
}
