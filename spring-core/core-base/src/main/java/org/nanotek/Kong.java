package org.nanotek;

import com.google.common.base.Supplier;

public interface Kong<K extends Kong<?>> extends Supplier<K> {
}