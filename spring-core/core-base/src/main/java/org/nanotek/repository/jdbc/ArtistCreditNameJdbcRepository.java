package org.nanotek.repository.jdbc;

import org.nanotek.beans.jdbc.ArtistCreditName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditNameJdbcRepository extends CrudRepository<ArtistCreditName, Long> {
}
