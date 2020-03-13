package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public interface NameBase<K extends Serializable> extends MutableName<K> ,  Nameable<K> , Base {
	
	@SuppressWarnings("unchecked")
	default <N extends NameBase<K>> N withName(@NotBlank K name) { 
		this.setName(name);
		return (N) this;
	}
	
}
