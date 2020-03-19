package org.nanotek.repository.jpa;


import org.nanotek.beans.entity.LongIdGidName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongIdGidNameEntityRepository<K extends LongIdGidName<?,?>> extends JpaRepository<K,Long>{
}
