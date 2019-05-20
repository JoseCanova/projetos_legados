package org.nanotek.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.function.LongConsumer;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonListArrayMapper implements Function<List<JSONObject>,JSONArray>{

	@Override
	public JSONArray apply(List<JSONObject> t) {
		JSONArray array = new JSONArray();
		t.stream().mapToLong(p -> p.getLong("id")).sorted().forEach(new LongConsumer(){
			@Override
			public void accept(long value) {
				array.put(value);
			} 
		});
		return array;
	}

}
