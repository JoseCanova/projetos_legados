package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ArtistAliasType;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistAliasTypeRepository extends BaseTypeRepository<ArtistAliasType> , NameBaseProjection<ArtistAliasType>{
}
