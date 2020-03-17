package org.nanotek.opencsv;

import java.util.HashMap;
import java.util.Optional;

import org.nanotek.Base;
import org.nanotek.BaseInstantiationException;
import org.nanotek.IdBase;
import org.nanotek.StringBase;

/**
 * TODO: Change the class to "create a equivalence validator" on Target Class - and the Map class. 
 * 
 * @author josecanovamauger.
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class BaseMap<T extends IdBase<T,String>> extends HashMap<String,Integer> implements StringBase<T> {

	//works fine with the "Bean Name";
	protected String id;
	protected Class<T> target; 
	protected Integer targetSize; 
	
	public BaseMap() {
	}
	
	public BaseMap(String id, Class<T> target, Integer targetSize) {
		super();
		this.id = id;
		this.target = target;
		this.targetSize = targetSize;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	public Class<T> getTarget() {
		return target;
	}

	public void setTarget(Class<T> type) {
		this.target = type;
	}

	public Integer getTargetSize() {
		return size();
	}
	
}
