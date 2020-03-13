package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public interface NameBase<K extends Serializable> extends MutableName<K>   {
	
	default NameBase<K> getName() { 
		return get().getName();
	}
	
	default NameBase<K> withName(@NotBlank K name) { 
		get().setName(name);
		return this;
	}

	@Override
	default NameBase<K> get(){ 
		return this;
	}
	
}
