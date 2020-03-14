package org.nanotek;

import java.io.Serializable;

public interface MutableNameBase<N extends Serializable>{
	
	void setName(N n);
}
