package org.nanotek.opencsv;

import java.util.Optional;

import org.nanotek.IdBase;

public interface ColumnMapHolder<K extends IdBase<K,?>>{
     Optional<K> verifyConfiguration();
}
