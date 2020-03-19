package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.LongIdName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongIdEntityNameBaseRepository<L extends LongIdName<?>> extends JpaRepository<L,Long> {
}
