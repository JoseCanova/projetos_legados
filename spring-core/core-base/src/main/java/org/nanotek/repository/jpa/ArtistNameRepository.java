package org.nanotek.repository.jpa;

import java.util.List;

import org.nanotek.beans.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistNameRepository extends JpaRepository <ArtistName ,Long> {
	
	@Query("from ArtistName a left outer join fetch a.artistCredits where a.artistId = ?1")
	List<ArtistName> findByArtistId(Long artistId);
	
	List<ArtistName> findByNameContainingIgnoreCase(String name);

}
