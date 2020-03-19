package org.nanotek;

import java.io.Serializable;
import java.util.Optional;

public interface Kong<K extends Kong<K>> {
	default <J extends K> Optional<J> get(J j){
		return Optional.of(j);
	}
}