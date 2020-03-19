package org.nanotek.repository.jpa;

import org.nanotek.LongIdEntityBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongIdEntityNameBaseRepository<L extends LongIdEntityBase> extends JpaRepository<L,Long> {
}
