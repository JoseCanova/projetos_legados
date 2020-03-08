package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.DatableBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatableBaseRepository<D extends DatableBase> extends JpaRepository<D,Long>{
}
