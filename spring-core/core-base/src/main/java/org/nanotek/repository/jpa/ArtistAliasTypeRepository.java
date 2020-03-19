package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ArtistAliasType;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistAliasTypeRepository<K extends ArtistAliasType<K,?>> extends 
LongIdGidNameEntityRepository<K>{
}
