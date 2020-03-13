package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ArtistSortName;
import org.nanotek.repository.jpa.projections.SortNameProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistSortNameRepository extends  EntityBaseRepository<ArtistSortName, Long> ,SortNameProjection<ArtistSortName>{
}
