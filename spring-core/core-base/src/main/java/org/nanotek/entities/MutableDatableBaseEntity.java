package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.DatableBaseEnity;

public interface MutableDatableBaseEntity <Y extends Serializable , M extends Serializable , D extends Serializable> extends DatableBaseEnity<Y,M,D>{

	void setYear(Y year); 
	
	void setMonth(M month);
	
	void setDay(D month);
	
}
