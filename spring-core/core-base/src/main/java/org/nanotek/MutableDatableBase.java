package org.nanotek;

import java.io.Serializable;

public interface MutableDatableBase <Y extends Serializable , M extends Serializable , D extends Serializable>{

	void setYear(Y year); 
	
	void setMonth(M month);
	
	void setDay(D month);
	
}
