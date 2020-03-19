package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.LongIdSortName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongIdSortNameEntityRepository<K extends LongIdSortName<?>> extends JpaRepository<K,Long> {
}
