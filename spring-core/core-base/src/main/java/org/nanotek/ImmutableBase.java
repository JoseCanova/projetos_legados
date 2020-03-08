package org.nanotek;

import java.io.Serializable;

@FunctionalInterface
public interface ImmutableBase <K extends Serializable> {
	K getId();
}
