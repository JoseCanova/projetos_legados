package org.nanotek;

import java.io.Serializable;
import java.util.Optional;

public interface Kong<K extends Kong<K>> extends Serializable{
	static <J extends Kong<?>> Optional<J> get(J j){
		return Optional.of(j);
	}
}