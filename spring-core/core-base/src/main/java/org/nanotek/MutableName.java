package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public interface MutableName<K extends Serializable> extends Nameable<K>{
	
	void setName(@NotBlank K name);
	
	
}
