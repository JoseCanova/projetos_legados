package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.InstrumentDescription;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentDescriptionRepository<I extends InstrumentDescription> extends DescriptionBaseRepository<I>{
}
