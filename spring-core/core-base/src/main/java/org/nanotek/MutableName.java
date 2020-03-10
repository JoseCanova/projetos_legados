package org.nanotek;

import javax.validation.constraints.NotBlank;

@FunctionalInterface
public interface MutableName {
	public void setName(@NotBlank String name);
}
