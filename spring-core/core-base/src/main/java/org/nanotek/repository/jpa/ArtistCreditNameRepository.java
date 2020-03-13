package org.nanotek.repository.jpa;

import java.util.List;

import org.nanotek.beans.entity.ArtistCreditName;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditNameRepository extends LongIdNameEntityRepository<ArtistCreditName> {
	
	public List<ArtistCreditName> findByArtistCreditId(Long id);
	
}
