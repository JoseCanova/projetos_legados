package org.nanotek;

import java.util.List;

public interface Nameable <T> {

	List<T> findByNameLike (String name);
	
	List<T> findByNameIgnoreCase (String name);
	
	List<T> findByNameLikeIgnoreCase (String name);
	
}
