package org.nanotek.opencsv;

import java.io.Serializable;
import java.util.HashMap;

import org.nanotek.IdBase;
import org.nanotek.entities.MutableBase;

/**
 * TODO: Change the class to "create a equivalence validator" on Target Class - and the Map class. 
 * 
 * @author josecanovamauger.
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class BaseMap<T extends IdBase<?,ID>, ID extends Serializable> 
extends HashMap<String,Integer> implements IdBase<T , ID> , MutableBase<ID>{

	//works fine with the "Bean Name";
	protected ID id;
	protected Integer targetSize; 
	
	public BaseMap() {
	}
	
	public BaseMap(ID id,  Integer targetSize) {
		super();
		this.id = id;
		this.targetSize = targetSize;
	}

	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(ID id) {
		this.id = id;
	}
	
	public Integer getTargetSize() {
		return size();
	}
	
}
