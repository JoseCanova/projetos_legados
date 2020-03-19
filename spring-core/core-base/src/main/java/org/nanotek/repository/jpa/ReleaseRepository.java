package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Release;
import org.nanotek.repository.jpa.projections.GidBaseProjection;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository 
extends IdBaseRepository<Release> , 
ReleaseBaseRepository<Release,Long>,
NameBaseProjection<Release>,
GidBaseProjection<Release>{
}
