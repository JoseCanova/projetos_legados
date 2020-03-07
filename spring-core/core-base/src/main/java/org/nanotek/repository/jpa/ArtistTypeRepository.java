package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ArtistType;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistTypeRepository extends BaseTypeRepository<ArtistType> , NameBaseProjection<ArtistType>{
}
