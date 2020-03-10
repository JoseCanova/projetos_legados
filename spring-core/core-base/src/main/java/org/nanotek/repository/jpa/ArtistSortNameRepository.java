package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ArtistSortName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistSortNameRepository extends JpaRepository<ArtistSortName,Long>{
}
