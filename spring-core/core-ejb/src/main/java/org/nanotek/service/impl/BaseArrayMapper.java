package org.nanotek.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.function.LongConsumer;

import org.json.JSONArray;

public class BaseArrayMapper implements Function<List<LongBase>,JSONArray>{

	@Override
	public JSONArray apply(List<LongBase> t) {
		JSONArray array = new JSONArray();
		t.stream().mapToLong(p -> p.getId()).sorted().forEach(new LongConsumer(){
			@Override
			public void accept(long value) {
				array.put(value);
			} 
		});
		return array;
	}

}
