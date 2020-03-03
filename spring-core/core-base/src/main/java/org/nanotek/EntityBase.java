package org.nanotek;

import java.io.Serializable;

@FunctionalInterface
public interface EntityBase<T extends Serializable> extends ImmutableBase<T> , Base{
}
