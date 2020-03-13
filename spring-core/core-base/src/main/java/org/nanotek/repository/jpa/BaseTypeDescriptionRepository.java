package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.BaseTypeDescription;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseTypeDescriptionRepository<B extends BaseTypeDescription> extends  DescriptionBaseRepository<B>  {
}
