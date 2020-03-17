package org.nanotek;

import java.io.Serializable;

public interface DatableBaseEnity <Y extends Serializable , M extends Serializable , D extends Serializable> extends Serializable{

	Y getYear();
	
	M getMonth();
	
	D getDay();
	
}
