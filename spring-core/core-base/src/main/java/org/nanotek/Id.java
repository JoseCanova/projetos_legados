package org.nanotek;

import java.io.Serializable;

public interface Id<ID extends Serializable> {
	ID getId();
}
