package org.nanotek.collections;

import java.io.Serializable;

import org.nanotek.beans.entity.Artist;
import org.springframework.data.util.Streamable;

public interface StreamableArtistEntity<K extends Artist<?>> extends Streamable<K> , Serializable{
}
