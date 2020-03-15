package org.nanotek.opencsv;

import java.util.HashMap;
import java.util.function.Consumer;

import org.nanotek.Base;
import org.nanotek.BaseInstantiationException;
import org.nanotek.IdBase;
import org.nanotek.ImmutableBase;
import org.nanotek.MutableId;
import org.nanotek.StringBase;

/**
 * TODO: Change the class to "create a equivalence validator" on Target Class - and the Map class. 
 * 
 * @author josecanovamauger.
 *
 * @param <T>
 */
//Avoiding the Usage of this. Type & AnnotatedElement & GenericDeclaration & Serializable & Base<?>
@SuppressWarnings("serial")
public class BaseMap<T extends IdBase<?>> extends HashMap<String,Integer> implements StringBase , ImmutableBase<T>{

	//works fine with the "Bean Name";
	protected String id;
	protected T target; 
	protected Integer targetSize; 
	
	public BaseMap() {
	}
	
	public BaseMap(String id, T target, Integer targetSize) {
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
	
	public T getTarget() {
		return target;
	}

	public void setTarget(T type) {
		this.target = type;
	}

	public Base<?> newInstance() throws BaseInstantiationException {
		return target.newInstance();
	}

	public Integer getTargetSize() {
		return size();
	}

	@Override
	public void on(Consumer<String> k) {
		k.accept(id);
	}
}
