package org.nanotek;

import javax.validation.constraints.NotNull;

@FunctionalInterface
public interface MutableName {
	public void setName(@NotNull String name);
}
