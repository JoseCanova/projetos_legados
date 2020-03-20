package org.nanotek.opencsv;

import java.io.Serializable;
import java.util.HashMap;

import org.nanotek.Holder;
import org.nanotek.IdBase;
import org.nanotek.entities.MutableBase;

/**
 * 
 * @author josecanovamauger.
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class BaseMap<T extends IdBase<?,ID>, ID extends Serializable> 
	extends HashMap<String,Integer> {

	protected ID id;
	
	public BaseMap() {
	}
	
	public BaseMap(ID id) {
		super();
		this.id = id;
	}

}
