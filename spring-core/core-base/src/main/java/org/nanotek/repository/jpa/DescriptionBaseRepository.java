package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.DescriptionBase;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionBaseRepository<K extends DescriptionBase> extends BaseDescriptionBaseRepository<K>{
}
