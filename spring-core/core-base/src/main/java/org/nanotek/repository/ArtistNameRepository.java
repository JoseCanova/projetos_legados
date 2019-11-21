package org.nanotek.repository;

import org.nanotek.beans.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistNameRepository extends JpaRepository <ArtistName ,Long> {

}
