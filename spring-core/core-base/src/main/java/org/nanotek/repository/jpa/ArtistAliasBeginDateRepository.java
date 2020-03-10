package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.ArtistAliasBeginDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistAliasBeginDateRepository extends JpaRepository<ArtistAliasBeginDate , Long>{
}
