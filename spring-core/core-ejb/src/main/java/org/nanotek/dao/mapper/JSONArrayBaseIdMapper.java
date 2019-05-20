package org.nanotek.dao.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.function.LongConsumer;

import org.json.JSONArray;
import org.nanotek.Base;

public class JSONArrayBaseIdMapper implements Function<List<Base<Long>>,JSONArray>{

	@Override
	public JSONArray apply(List<Base<Long>> t) {
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
