package org.nanotek.repository.jpa;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.nanotek.beans.entity.Instrument;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository<K extends Instrument<K>> 
extends IdBaseRepository<InstrumentRepository<K>,K>{
	Optional<K> findByInstrumentId(@NotNull Long instrumentId);
}
