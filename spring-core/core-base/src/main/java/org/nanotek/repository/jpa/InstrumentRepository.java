package org.nanotek.repository.jpa;

import org.nanotek.beans.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument,Long>{
}
