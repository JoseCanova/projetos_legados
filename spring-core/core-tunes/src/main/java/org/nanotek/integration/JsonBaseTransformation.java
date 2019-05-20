package org.nanotek.integration;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.nanotek.Base;

public abstract class JsonBaseTransformation <T extends Base<?>>implements Transformation <T , JSONObject>{

	private Class<T> instanceClass;

	public JsonBaseTransformation() {
	}
	
	public JsonBaseTransformation(Class<T> clazz) {
		this.instanceClass = clazz;
	}

	@Override
	public T transform(JSONObject info) {
		T instance = newInstance();
		info.keys().forEachRemaining(t ->
		copyProperty(t ,  info, instance)
				);
		return instance;
	}

	private void copyProperty(String t, JSONObject info , T instance) {
		try {
			BeanUtils.copyProperty(instance , t, info.get(t));
		} catch (IllegalAccessException | InvocationTargetException
				| JSONException e) {
			e.printStackTrace();
		}
	}

	private T newInstance(){
		try {
			  return instanceClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not instantiate Base Class");
		}
	}

}
