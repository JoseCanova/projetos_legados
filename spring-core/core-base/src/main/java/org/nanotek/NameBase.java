package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public interface NameBase<K extends Serializable> extends MutableName<K>   {
	
	NameBase<K> getName();
	
	NameBase<K> withName(@NotBlank K name);
	
}
