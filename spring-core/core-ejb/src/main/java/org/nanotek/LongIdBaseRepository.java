package org.nanotek;


public interface LongIdBaseRepository <T extends Base<Long>> {

	public T findById(Long id);
	
}
