package org.nanotek;

import org.nanotek.Base;

public interface LongIdBaseRepository <T extends Base<Long>> {

	public T findById(Long id);
	
}
