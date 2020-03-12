package org.nanotek;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

@FunctionalInterface
public interface MutableName<K extends Serializable> {
	public void setName(@NotBlank K name);
}
