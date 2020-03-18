package org.nanotek.collections;

import java.util.List;

import org.nanotek.Base;
import org.nanotek.Kong;

public interface MutableListEntity<K extends Base<?>, ID extends Kong<?>> 
	extends List<ID> ,
	Base<K> {
}
