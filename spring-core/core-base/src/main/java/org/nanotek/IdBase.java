package org.nanotek;

import java.io.Serializable;
 
public interface IdBase<K extends Serializable> extends Base<IdBase<K>> , Holder<IdBase<K>> {

	default void setId(K id) { 
		get().setId(id);
	}
	
	
	default IdBase<K> withId(K id) { 
		get().setId(id);
		return this;
	}
	
	@Override
	default IdBase<K> get() { 
		return this;
	}

	default void on() { 
		on(get());
	}
	
	@Override
	default void on(IdBase<K> s) {
			on();
	}
	
}
