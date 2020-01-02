package org.nanotek.repository.jpa;

import org.nanotek.beans.flat.FlatArtistNameCreditRel;
import org.nanotek.beans.flat.FlatArtistNameCreditRelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistNameCreditRelRepository extends JpaRepository <FlatArtistNameCreditRel , FlatArtistNameCreditRelId>{
}
