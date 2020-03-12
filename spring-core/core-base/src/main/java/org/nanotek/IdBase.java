package org.nanotek;

import java.io.Serializable;

import org.nanotek.Base;
import org.nanotek.ImmutableBase;
import org.nanotek.MutableBase;

public interface IdBase<K extends Serializable> extends MutableBase<K> , ImmutableBase<K> ,  Base {

	default IdBase<K> withId(K id) { 
		this.setId(id);
		return this;
	}
	
}
