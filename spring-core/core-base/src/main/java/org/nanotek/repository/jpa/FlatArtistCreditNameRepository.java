package org.nanotek.repository.jpa;

import org.nanotek.beans.flat.FlatArtistCreditName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatArtistCreditNameRepository extends JpaRepository<FlatArtistCreditName, Long> {
}
