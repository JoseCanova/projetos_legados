package org.nanotek;

import java.io.Serializable;

public interface EntityNameBase<T extends Serializable, N extends Serializable> extends EntityBase<T>,NameBase<N>{
}
