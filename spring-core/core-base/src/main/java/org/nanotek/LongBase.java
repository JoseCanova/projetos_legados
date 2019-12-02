package org.nanotek;

import javax.persistence.MappedSuperclass;

import com.google.gson.Gson;

@MappedSuperclass
public interface LongBase extends Base<Long>{
	
		default String toJson () 
		{ 
			return new Gson().toJson(this);
		}
}
