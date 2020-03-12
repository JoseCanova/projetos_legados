package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public interface NameBase<K extends Serializable> extends MutableName<K> ,  Nameable<K> {
	
	default NameBase<K> withName(@NotBlank K name) { 
		this.setName(name);
		return this;
	}
	
}
