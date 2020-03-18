package org.nanotek.collections;

import java.util.Optional;

import org.nanotek.Result;
import org.nanotek.beans.entity.Artist;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.stream.StreamableEntity;

public interface AritistCreditStreamableEntity<K extends ArtistCredit<?>> extends StreamableEntity<K>{
}
