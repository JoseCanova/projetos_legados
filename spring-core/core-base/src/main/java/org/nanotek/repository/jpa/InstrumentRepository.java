package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Instrument;
import org.nanotek.repository.jpa.projections.NameBaseProjection;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends IdBaseRepository<Instrument<?>>{
	Optional<Instrument<?>> findByInstrumentId(@NotNull Long instrumentId);
}
