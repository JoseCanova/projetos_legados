package org.nanotek.integration;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.nanotek.Base;
import org.nanotek.integration.tune.TuneArtistWrapperTransformation;
import org.nanotek.integration.tune.model.TuneArtistWrapperType;

public class JsonBaseTransformationAdapter <T extends Base<?>>implements Transformation <T , JSONObject> {

	private static  Map<Class<?> , Transformation<?,JSONObject> > adaptees = new HashMap<Class<?> , Transformation<?,JSONObject> >();

	private Class<?> instanceClass;

	static { 
		adaptees.put(TuneArtistWrapperType.class , new TuneArtistWrapperTransformation());
	}


	public JsonBaseTransformationAdapter(Class<?> instanceClass) {
		this.instanceClass = instanceClass;
	}

	@Override
	public T transform(JSONObject info) {
		return (T) adaptees.get(instanceClass).transform(info);
	}

}
